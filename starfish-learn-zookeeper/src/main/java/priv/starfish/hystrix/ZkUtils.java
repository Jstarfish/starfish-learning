package priv.starfish.hystrix;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: starfish
 * @create: 2020-03-11 15:12
 **/
public class ZkUtils implements Watcher, Serializable {
    private static final Logger log = LoggerFactory.getLogger(ZkUtils.class);
    private ZooKeeper zk = null;
    private String connectString;
    private int sessionTimeout = 100000;
    private String registerPath = null;
    private CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public ZkUtils(String connectString, int sessionTimeout) {
        this.connectString = connectString;
        this.sessionTimeout = sessionTimeout;
    }

    public void createConnection() {
        try {
            //this.connectString = "10.208.32.138:2181,10.208.32.156:2181,10.208.32.173:2181";
            this.zk = new ZooKeeper(this.connectString, this.sessionTimeout,
                    this);
            this.connectedSemaphore.await();
        } catch (InterruptedException e) {
            log.error("Create Zk connection error, InterruptedException");
            e.printStackTrace();
        } catch (IOException e) {
            log.error("Create Zk connection error, IOException");
            e.printStackTrace();
        }
    }

    public void releaseConnection() {
        if (this.zk != null) {
            try {
                this.zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerPath(String path) {
        this.registerPath = path;
    }

    public boolean createEphPath(String path, String data) {
        try {
            if (data != null) {
                this.zk.create(path, data.getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            } else {
                this.zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.EPHEMERAL);
            }
            log.info("Create node " + path + " successfully");
        } catch (KeeperException e) {
            log.error("Create Zk node" + path + " error, KeeperException");
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            log.error("Create Zk node " + path + " error, InterruptedException");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean createPersisPath(String path, String data) {
        try {
            if (data != null) {
                this.zk.create(path, data.getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            } else {
                this.zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.PERSISTENT);
            }
            log.info("Create node " + path + " successfully");
        } catch (KeeperException e) {
            log.error("Create Zk node" + path + " error, KeeperException");
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            log.error("Create Zk node " + path + " error, InterruptedException");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String readData(String path) {
        try {
            byte[] data = this.zk.getData(path, false, null);
            log.info("Get data from Zk node " + path + " successfully");
            return new String(data);
        } catch (KeeperException e) {
            log.error("Get data from Zk node " + path
                    + " error, KeeperException");
            e.printStackTrace();
            return "";
        } catch (InterruptedException e) {
            log.error("Get data from Zk node " + path
                    + " error, InterruptedException");
            e.printStackTrace();
        }
        return "";
    }

    public boolean writeData(String path, String data) {
        try {
            this.zk.setData(path, data.getBytes(), -1);
            log.info("Write to Zk node " + path + " successfuly");
            return true;
        } catch (KeeperException e) {
            log.error("Write to Zk node " + path + " error, KeeperException");
            e.printStackTrace();
        } catch (InterruptedException e) {
            log.error("Write to Zk node " + path
                    + " error, InterruptedException");
            e.printStackTrace();
        }
        return false;
    }

    public boolean existPath(String path) {
        try {
            Stat stat = this.zk.exists(path, true);
            return stat != null;
        } catch (KeeperException e) {
            log.error("Check Zk node " + path
                    + " exists error, KeeperException");
            e.printStackTrace();
        } catch (InterruptedException e) {
            log.error("Check Zk node " + path
                    + " exists error, InterruptedException");
            e.printStackTrace();
        }
        return false;
    }

    public List<String> getChildren(String path) {
        try {
            return this.zk.getChildren(path, true);
        } catch (KeeperException e) {
            log.error("Check Zk node " + path
                    + " exists error, KeeperException");
            e.printStackTrace();
        } catch (InterruptedException e) {
            log.error("Check Zk node " + path
                    + " exists error, InterruptedException");
            e.printStackTrace();
        }
        return null;
    }

    public void deletePath(String path) {
        try {
            this.zk.delete(path, -1);
            log.info("Delete Zk node " + path + " successfuly");
        } catch (KeeperException e) {
            log.error("Delete Zk node " + path + "error, KeeperException");
            e.printStackTrace();
        } catch (InterruptedException e) {
            log.error("Delete Zk node " + path + " error, InterruptedException");
            e.printStackTrace();
        }
    }

//    String getBrokerList(String brokerPath) {
//        List<String> listPath = getChildren(brokerPath);
//        if ((listPath == null) || (listPath.isEmpty())) {
//            return null;
//        }
//        String brokerList = null;
//        for (String path : listPath) {
//            String absPath = brokerPath + "/" + path;
//            try {
//                String data = readData(absPath);
//                JSONObject jsonData = new JSONObject(data);
//                String host = jsonData.getString("host");
//                int port = jsonData.getInt("port");
//                String broker = host + ":" + Integer.toString(port);
//                if (brokerList == null) {
//                    brokerList = broker;
//                } else {
//                    brokerList = brokerList + "," + broker;
//                }
//                break;
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return brokerList;
//    }

    public void process(WatchedEvent event) {
        System.out.println("Zk event watched:" + event.getState() + "\n");
        if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
            this.connectedSemaphore.countDown();
        } else if (Watcher.Event.KeeperState.Expired == event.getState()) {
            log.warn("Zk session expired, reconnect");
            releaseConnection();
            this.connectedSemaphore = new CountDownLatch(1);
            createConnection();
            if (this.registerPath != null) {
                createEphPath(this.registerPath, null);
            }
        }
    }

}
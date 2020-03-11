package priv.starfish.demo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: starfish
 * @create: 2020-03-11 14:26
 **/
public class ZkClientTest implements Serializable {


    private static final Logger log = LoggerFactory.getLogger(ZkClientTest.class);
    private ZooKeeper zk = null;
    private String connectString = "10.121.214.95:2181";
    private int sessionTimeout = 100000;

    private CountDownLatch connectedSemaphore = new CountDownLatch(1);


    /* *
     * Zookeeper API 提供了多种构造器：https://zookeeper.apache.org/doc/r3.5.7/apidocs/zookeeper-server/index.html
     **/
//    @Before
//    public void createConnection() {
//        try {
//            //this.connectString = "10.121.214.95:2181,10.208.32.156:2181,10.208.32.173:2181";
//            this.connectString = "10.121.214.95:2181";
//            this.zk = new ZooKeeper(this.connectString, this.sessionTimeout,
//                    this);
//            this.connectedSemaphore.await();
//        } catch (InterruptedException e) {
//            log.error("Create Zk connection error, InterruptedException");
//            e.printStackTrace();
//        } catch (IOException e) {
//            log.error("Create Zk connection error, IOException");
//            e.printStackTrace();
//        }
//    }

    //创建zookeeper客户端
    @Before
    public void init(){
        try {
            zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
                public void process(WatchedEvent event) {
                    // 收到事件通知后的回调函数（用户的业务逻辑）
                    System.out.println(event.getType() + "--" + event.getPath());

                    // 再次启动监听
                    try {
                        zk.getChildren("/", true);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 创建子节点
    @Test
    public void create() throws Exception {
        // 参数1：要创建的节点的路径； 参数2：节点数据 ； 参数3：节点权限 ；参数4：节点的类型
        String nodeCreated = zk.create("/lazyegg", "star".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    //获取子节点并监听节点变化
    @Test
    public void getChildren() throws Exception {

        List<String> children = zk.getChildren("/", true);

        for (String child : children) {
            System.out.println(child);
        }

        // 延时阻塞
        //Thread.sleep(Long.MAX_VALUE);
    }


    //判断znode是否存在
    @Test
    public void exist() throws Exception {

        Stat stat = zk.exists("/go", false);
        Stat stat1 = zk.exists("/lazyegg", false);

        System.out.println(stat == null ? "not exist" : "exist");
        System.out.println(stat1 == null ? "not exist" : "exist");
    }








}

package priv.starfish.hystrix;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @description: Curator使用
 * @author: starfish
 * @create: 2020-03-27 11:25
 **/
public class CuratorTest {

    public String zookeeperConnectionString = "10.121.214.95:2181";
    CuratorFramework client;

    /**
     *  创建客户端，两种方式，默认客户端，带参数的客户端创建
     */
    @Before
    public void CreateClient() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
        client.start();
    }

    /**
     * 有了CuratorFramework 实例，就可以使用了,先来创建个空节点
     */
    @Test
    public void createPath() {
        try {
            client.create().forPath("/myPath1");
            client.create().forPath("/myPath1/myChildren1");
            client.create().forPath("/myPath1/myChildren2");
            //client.create().forPath("/myPath1","myData1".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建临时节点
     * 和持久节点不同的是，临时节点的生命周期和客户端会话绑定。
     * 也就是说，如果客户端会话失效，那么这个节点就会自动被清除掉。
     * 注意，这里提到的是会话失效，而非连接断开。另外，在临时节点下面不能创建子节点。
     */
    @Test
    public void createEphemeral() throws Exception {
        client.create().withMode(CreateMode.EPHEMERAL).forPath("/myPath2", "myData2".getBytes());
    }

    /**
     *  为节点设置数据
     */
    @Test
    public void setData() throws Exception {
        client.setData().forPath("/myPath1", "myData1".getBytes());
    }

    /**
     *  列出子节点
     */
    @Test
    public void watchedGetChildren() throws Exception {
        List<String> list = client.getChildren().watched().forPath("/myPath1");
        for (String s : list) {
            System.out.println(s);
        }
    }


    /**
     *  删除节点
     *  sguaranteed()：接口是一个保障措施，只要客户端会话有效，那么Curator会在后台持续进行删除操作，直到节点删除成功
     *  deletingChildrenIfNeeded()： 删除一个节点，并递归删除其所有子节点
     *
     *  正如该接口的官方文档中所注明的，在ZooKeeper客户端使用过程中，可能会碰到这样的问题：
     *  客户端执行一个删除节点操作，但是由于一些网络原因，导致删除操作失败。
     *  对于这个异常，在有些场景中是致命的，
     *  如“Master选举”——在这个场景中，ZooKeeper客户端通常是通过节点的创建与删除来实现的。
     *  针对这个问题，Curator中引入了一种重试机制：
     *  如果我们调用了guaranteed()方法，那么当客户端碰到上面这些网络异常的时候，
     *  会记录下这次失败的删除操作，只要客户端会话有效，那么其就会在后台反复重试，直到节点删除成功。
     *  通过这样的措施，就可以保证节点删除操作一定会生效。
     */
    @Test
    public void guaranteedDelete() throws Exception {
        //client.delete().forPath("/myPath1");
        //client.delete().guaranteed().forPath("/myPath1");
        client.delete().deletingChildrenIfNeeded().forPath("/myPath1");
    }




}

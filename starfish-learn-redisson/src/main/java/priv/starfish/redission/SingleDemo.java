package priv.starfish.redission;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

import java.util.concurrent.TimeUnit;

/**
 * @description: 单机模式hello world，main 方法里插入数据，在本地查不到》？？
 * @author: starfish
 * @date: 2021/8/2 17:20
 */
public class SingleDemo {

    public static void main(String[] args) {

        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379").setPassword(null).setDatabase(0);

        //.setTimeout(redissonProperties.getTimeout())
        //.setDatabase(redissonProperties.getDatabase())
        //.setConnectionPoolSize(redissonProperties.getConnectionPoolSize())
        //.setConnectionMinimumIdleSize(redissonProperties.getConnectionMiniumIdleSize());
       /* if (StringUtils.isNotEmpty(redissonProperties.getPassword())) {
            serverConfig.setPassword(redissonProperties.getPassword());
        }*/

        //config.useSingleServer().setAddress("127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);
        RLock disLock = redissonClient.getLock("myLock");
        RLock disLock1 = redissonClient.getLock("myLock1");

        boolean isLock;
        try {
            /**
             * 尝试获取锁的最大等待时间是 100 秒，超过这个值还没获取到，就认为获取失败
             * 锁的持有时间是 10 秒
             */
            isLock = disLock.tryLock(100, 10, TimeUnit.MILLISECONDS);
            if (isLock) {
                //做自己的业务
                System.out.println(redissonClient.getBucket("myLock").get());
                Thread.sleep(100);
                System.out.println(redissonClient.getBucket("name").get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disLock.unlock();
        }
    }


}

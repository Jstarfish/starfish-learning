package priv.starfish;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RFuture;
import org.redisson.api.RKeys;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import priv.starfish.schedule.service.impl.RedissonDistributedLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonApplicationTests {

    @Autowired
    private RedissonDistributedLock redissonLock;

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void contextLoads() throws Exception {
        int count = 10;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(() -> {
                try {
                    String lockKey = "MyLock";
                    redissonLock.tryLock(lockKey, TimeUnit.SECONDS, 100, 8);
                    System.out.println("===加锁===" + Thread.currentThread().getName());

                    System.out.println("===做自己操作===");
                    Thread.sleep(5000);

                    System.out.println("===释放锁===" + Thread.currentThread().getName());
                    redissonLock.unlock(lockKey);

                    System.out.println(latch.getCount());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
            thread.start();

        }
        latch.await();
    }




    @Test
    public void redisOperate(){
        RKeys keys = redissonClient.getKeys();
        Iterable<String> allKeys = keys.getKeys();
        allKeys.forEach(System.out::println);
        /*Iterable<String> foundedKeys = keys.getKeysByPattern('key*');
        long numOfDeletedKeys = keys.delete("obj1", "obj2", "obj3");
        long deletedKeysAmount = keys.deleteByPattern("test?");
        String randomKey = keys.randomKey();
        long keysAmount = keys.count();*/
       // System.out.println("-----"+allKeys);
    }

    public void redisLock() throws InterruptedException {
        RedissonClient redissonClient = Redisson.create();
        RLock rLock = redissonClient.getLock("resourceName");
        //直接加锁
        //rLock.lock();
        //尝试加锁5秒，锁过期时间10秒
        rLock.tryLock(5,10,TimeUnit.SECONDS);
        //非阻塞异步加锁
        RFuture<Boolean> rFuture = rLock.tryLockAsync(5,10,TimeUnit.SECONDS);
        rLock.unlock();
    }



}


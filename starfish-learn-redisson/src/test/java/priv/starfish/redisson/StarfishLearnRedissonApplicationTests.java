package priv.starfish.redisson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import priv.starfish.schedule.service.impl.RedissonDistributedLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarfishLearnRedissonApplicationTests {

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
                    String lockKey = "17631701110";
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


}


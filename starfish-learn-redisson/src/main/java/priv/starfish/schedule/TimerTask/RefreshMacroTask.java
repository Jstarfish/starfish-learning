package priv.starfish.schedule.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import priv.starfish.schedule.service.impl.RedissonDistributedLock;
import priv.starfish.schedule.utils.CommonUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * @author: jiahaixin
 * @date: 2018/12/28 17:32
 */

@EnableScheduling
//开启异步调用方法
//@EnableAsync
@Component
public class RefreshMacroTask {


    private final static Logger trace = LoggerFactory.getLogger("trace");
    private final static Logger logger = LoggerFactory.getLogger("product");

    @Autowired
    private RedissonDistributedLock redissonLock;


    /**
     * @description: 整点前5分钟刷新ES-query中的时间戳
     * @param: []
     * @return: void
     * @date: 2018/12/20 17:43
     */

    //@Scheduled(cron = "0 55 0/1 * * ? ")
    @Scheduled(cron = "0/20 * * * * ? ")
    public void macroFieldRefreshTask() throws Exception {

        System.out.println(Thread.currentThread().getName() + " >>> task one " + format.format(new Date()));

        trace.info("刷新ES-query定时任务启动......");

        String lockKey = "TASK-LOCK";
        boolean getLock = false;
        long start = System.currentTimeMillis();
        try {

            //若任务执行时间过短，则有可能在等锁的过程中2个服务任务都会获取到锁，这与实际需要的功能不一致，故需要将waitTime设置为0
            if (getLock = redissonLock.tryLock(lockKey, TimeUnit.SECONDS, 0, 10000)) {

                trace.info("host：" + CommonUtils.getInet4Address() + "  got lock " + lockKey + "  at " + CommonUtils.getCurrentDate());

                //TODO
                Thread.sleep(10000);

            } else {
                trace.info("host：" + CommonUtils.getInet4Address() + "  got lock fail at " + CommonUtils.getCurrentDate());
            }
        } catch (Exception e) {
            trace.error("Redisson get lock error", e);
        } finally {
            if (!getLock) {
                return;
            }
            // redissonLock.unlock(lockKey);
            trace.info("host：" + CommonUtils.getInet4Address() + " unlocked " + lockKey + " at " + CommonUtils.getCurrentDate());
            long end = System.currentTimeMillis();
            trace.info("refresh es_query time:" + (end - start));
        }

    }


    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedDelay = 1000)
    public void secondTask() {
        System.out.println(Thread.currentThread().getName() + " >>> task two " + format.format(new Date()));
    }

}

package priv.starfish.springbootlearn;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: jiahaixin
 * @date: 2019/5/9 10:54
 * @description:
 */
@Component
@EnableAsync
public class ScheduledTask {

    private final Log logger = LogFactory.getLog(this.getClass());

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Async
    @Scheduled(fixedDelayString = "${jobs.fixedDelay}")
    public void getTask1() {
        logger.info(Thread.currentThread().getName() + "===任务1,从配置文件加载任务信息，当前时间：" + dateFormat.format(new Date()));
    }

    @Async
    @Scheduled(cron = "${jobs.cron}")
    public void getTask2() {
        logger.info(Thread.currentThread().getName()+ "===任务2,从配置文件加载任务信息，当前时间：" + dateFormat.format(new Date()));
    }
}

package priv.starfish.springbootlearn.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;


/**
 * @author: jiahaixin
 * @date: 2019/5/9 14:37
 * @description: 异步任务配置类，可配置线程信息
 */

@Configuration
@EnableAsync
public class AsyncConfig {


    @Bean(destroyMethod = "shutdown")
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(2);
        // 设置线程名前缀
        scheduler.setThreadNamePrefix("task-");
        // 线程内容执行完后60秒停在
        scheduler.setAwaitTerminationSeconds(60);
        // 等待所有线程执行完
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        return scheduler;
    }
}

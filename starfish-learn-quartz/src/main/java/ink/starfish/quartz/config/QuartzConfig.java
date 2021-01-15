package ink.starfish.quartz.config;
import ink.starfish.quartz.quartz.MyJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-26 16:45
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail testQuartz() {
        return JobBuilder.newJob(MyJob.class).withIdentity("myTask").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger() {
        //cron方式，每隔5秒执行一次
        return TriggerBuilder.newTrigger().forJob(testQuartz())
                .withIdentity("myTask")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .build();
    }


}

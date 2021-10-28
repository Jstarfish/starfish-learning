package priv.starfish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import priv.starfish.schedule.redisson.RedissonProperties;

@SpringBootApplication
@PropertySource(value = {"classpath:application.yaml"})
@EnableConfigurationProperties(value = {RedissonProperties.class})
@ImportResource
public class ScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }

}


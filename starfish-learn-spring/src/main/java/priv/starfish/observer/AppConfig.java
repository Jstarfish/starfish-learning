package priv.starfish.observer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-18 17:48
 **/
@Configuration
@ComponentScan
public class AppConfig {

    @Bean(name = "myPublisher")
    public MyPublisher myPublisher(){
        return new MyPublisher();
    }
}

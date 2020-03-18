package priv.starfish.observer;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @description: 发布者
 * @data: 2020-03-18 16:26
 **/
@Component
public class MyPublisher implements ApplicationContextAware {


    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    public void publishEvent(ApplicationEvent event){
        System.out.println("publish event");
        applicationContext.publishEvent(event);
    }
}

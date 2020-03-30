package priv.starfish.observer;

import org.apache.catalina.core.ApplicationFilterChain;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExecutionChain;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-18 16:35
 **/


public class Client {


    @Test
    public void main() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyPublisher myPublisher = (MyPublisher) context.getBean("myPublisher");
        myPublisher.publishEvent(new MyEvent(this));

        HandlerExecutionChain；
                DiapatcherServlet

    }


}

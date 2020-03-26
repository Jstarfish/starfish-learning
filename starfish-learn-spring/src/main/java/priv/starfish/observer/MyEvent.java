package priv.starfish.observer;

import org.springframework.cache.transaction.TransactionAwareCacheDecorator;
import org.springframework.context.ApplicationEvent;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestWrapper;


/**
 * @description: 事件
 * @author: starfish
 * @data: 2020-03-18 11:50
 **/
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
        System.out.println("my Event");
    }


}

package priv.starfish.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: 监听器去监听事件
 * @author: starfish
 * @data: 2020-03-18 11:47
 **/
@Component
class MyListenerB implements ApplicationListener<MyEvent> {


    public void onApplicationEvent(MyEvent AyEvent) {
        System.out.println("ListenerB received");
    }
}



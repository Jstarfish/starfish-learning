package priv.starfish;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @description:
 * @author: starfish
 * @create: 2020-07-10 16:33
 **/

@Component
public class TaskShutdownHook {

    @PreDestroy
    public void run() {
        System.out.println("dts ShutdownHook fired.backup data!!!!!!!!!");


    }

}

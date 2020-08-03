package priv.starfish.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: starfish
 * @data: 2020-08-02 18:42
 **/
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (int i = 0; i < 10; i++) {
            Object bean = context.getBean("sheep");
            System.out.println(bean);
        }
    }
}

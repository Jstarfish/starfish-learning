package priv.starfish.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/13 15:15
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Calculator calculator = (Calculator)ctx.getBean("calculator");
        calculator.add(2,3);
    }
}

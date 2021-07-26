package priv.starfish.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/22 20:44
 */
public class DeclareClient {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        IMaxCalculator maxCalculator = ctx.getBean("pureCalculator", IMaxCalculator.class);
        maxCalculator.max(30, 40);
        IMinCalculator minCalculator = ctx.getBean("pureCalculator", IMinCalculator.class);
        minCalculator.min(30, 40);

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}

package strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 使用策略模式
 * @author: starfish
 * @date: 2021/4/16 16:07
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.doSomething();

        Map<String,String> map =null;
        System.out.println(map.get("ss"));

    }
}

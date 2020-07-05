package priv.starfish.observer;

import org.springframework.aop.framework.DefaultAopProxyFactory;

import java.util.HashMap;

/**
 * @description: https://www.jianshu.com/p/007bd6e1ba1b
 * @author: starfish
 * @create: 2020-06-18 17:10
 **/
public class Aop {

    public static void main(String[] args) {
// 构造hashmap
        HashMap newmap = new HashMap();

// 给hashmap赋值
        newmap.put(1, "tutorials");
        newmap.put(2, "point");
        newmap.put(3, "is best");

        System.out.println("Values before remove: "+ newmap);

// 移除key为2的value
        System.out.println(newmap.remove(2));
    }


}

package priv.starfish.proxypattern.jdkproxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: jiahaixin
 * @date: 2019/6/21 11:40
 * @description:
 */
public class MyInvocationHandler implements InvocationHandler {


    Subject subject;

    public MyInvocationHandler(Subject subject) {
        this.subject = subject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke proxy class");
        if (method.getName().equals("sellBooks")) {
            int invoke = (int) method.invoke(subject, args);
            System.out.println("调用的是卖书的方法");
            return invoke;
        } else {
            String string = (String) method.invoke(subject, args);
            System.out.println("调用的是说话的方法");
            return string;
        }

    }
}

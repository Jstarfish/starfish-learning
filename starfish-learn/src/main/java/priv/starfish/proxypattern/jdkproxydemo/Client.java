package priv.starfish.proxypattern.jdkproxydemo;

import java.lang.reflect.Proxy;

/**
 * @author: jiahaixin
 * @date: 2019/6/21 11:46
 * @description:
 */
public class Client {

    public static void main(String[] args) {
        //真实对象
        Subject realSubject = new RealSubject();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        //代理对象
        Subject proxyClass = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, myInvocationHandler);

        proxyClass.sellBooks();

        proxyClass.speak();
    }
}

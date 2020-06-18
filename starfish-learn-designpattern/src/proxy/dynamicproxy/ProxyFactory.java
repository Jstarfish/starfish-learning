package proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 动态代理工厂类
 * @author: starfish
 * @create: 2020-06-18 11:24
 **/
public class ProxyFactory {

    /**
     * 维护一个目标对象
     **/
    private Object target;

    /**
     * 构造器，初始化目标对象
     **/
    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {

        /**
         被代理对象target通过参数传递进来，
         通过target.getClass().getClassLoader()获取ClassLoader对象，
         然后通过target.getClass().getInterfaces()获取它实现的所有接口，
         再将target包装到实现了InvocationHandler接口的对象中。
         通过newProxyInstance函数我们就获得了一个动态代理对象。
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(bannedSites.contains(args[0].toString().toLowerCase()))
                {
                    throw new Exception("Access Denied:"+args[0]);
                }
                //反射机制调用目标对象的方法
                Object obj = method.invoke(target, args);
                return obj;
            }
        });
    }

    private static List<String> bannedSites;

    static
    {
        bannedSites = new ArrayList<String>();
        bannedSites.add("bilibili.com");
        bannedSites.add("youtube.com");
        bannedSites.add("weibo.com");
        bannedSites.add("qq.com");
    }

}

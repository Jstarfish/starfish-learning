package priv.starfish.aop.trouble;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @description: 日志处理
 * @author: starfish
 * @date: 2021/7/13 19:54
 */
public class LoggingHandler implements InvocationHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 被代理的目标对象
     */
    private Object proxyObj;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("The method " + method.getName() + " begins with " + Arrays.toString(args));
        Object result = method.invoke(proxyObj,args);
        log.info("The method " + method.getName() + " ends with " + Arrays.toString(args));
        return result;
    }

    public Object createProxy(Object proxyObj){
        this.proxyObj = proxyObj;
        //返回一个代理对象
        return Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(),
                proxyObj.getClass().getInterfaces(),this);
    }
}

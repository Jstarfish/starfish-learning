package priv.starfish.aop.trouble;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 正数验证
 * @author: starfish
 * @date: 2021/7/14 10:03
 */
public class ValidationHandler implements MethodInterceptor {

    /**
     * 被代理的目标对象
     */
    private Object targetObject;


    public Object createProxy(Object targetObject){
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();
        //设置代理目标
        enhancer.setSuperclass(targetObject.getClass());
        //设置回调
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 在代理实例上处理方法调用并返回结果
     * @param o ： 代理类
     * @param method ：被代理的方法
     * @param objects ：该方法的参数数组
     * @param methodProxy
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;

        for (Object object : objects) {
            if(Integer.parseInt(object.toString()) < 0){
                throw new IllegalArgumentException("Positive numbers only");
            }
        }
        //执行目标对象的方法
        result = methodProxy.invoke(targetObject,objects);
        return result;
    }
}

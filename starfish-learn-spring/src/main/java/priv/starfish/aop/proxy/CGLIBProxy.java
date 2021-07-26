package priv.starfish.aop.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: cglib 动态代理
 * @author: starfish
 * @date: 2021/7/13 11:35
 */
public class CGLIBProxy implements MethodInterceptor {

    /**
     * 被代理的目标对象
     */
    private Object targetObject;

    public Object createProxyInstance(Object targetObject){
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

        System.out.println("前置处理...");
        //执行目标对象的方法
        result = methodProxy.invoke(targetObject,objects);
        System.out.println("后置处理...");
        return result;
    }
}

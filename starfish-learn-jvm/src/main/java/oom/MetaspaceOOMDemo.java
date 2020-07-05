package oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * @author: starfish
 * @data: 2020-07-05 18:41
 **/
public class MetaspaceOOMDemo {

    public static void main(String[] args) {

        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MetaspaceOOMDemo.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
                //动态代理创建对象
                return methodProxy.invokeSuper(o, objects);
            });
            enhancer.create();
        }
    }
}

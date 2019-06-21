package priv.starfish.proxypattern.cglib;

/**
 * @author: jiahaixin
 * @date: 2019/6/21 11:54
 * @description:
 */
public class CglibMainTest {

    public static void main(String[] args) {
        // 生成 Cglib 代理类
        Engineer engineerProxy = (Engineer) CglibProxy.getProxy(new Engineer());
        // 调用相关方法
        engineerProxy.eat();
    }
}

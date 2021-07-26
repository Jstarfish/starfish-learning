package priv.starfish.aop.proxy;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/13 11:26
 */
public class Client {

    public static void main(String[] args) {
        TestService service = new TestServiceImpl();
        service.test();

        System.out.println("=====");

        JDKDynamicProxy proxy = new JDKDynamicProxy();
        TestService proxyService = (TestService) proxy.newProxy(service);
        proxyService.test();

        System.out.println(" ----- cglib test -----");
        TestCGLIBServiceImpl testCGLIBService = new TestCGLIBServiceImpl();
        CGLIBProxy cglibProxy = new CGLIBProxy();
        TestCGLIBServiceImpl proxyInstance = (TestCGLIBServiceImpl) cglibProxy.createProxyInstance(testCGLIBService);
        proxyInstance.test();
    }
}

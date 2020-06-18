package proxy.dynamicproxy;

import proxy.staticproxy.Internet;
import proxy.staticproxy.ProxyInternet;

/**
 * @description:
 * @author: starfish
 * @create: 2020-06-17 18:28
 **/
public class Client {

    public static void main(String[] args) {

        //目标对象
        RealInternet target = new RealInternet();
        Internet internet = (Internet) new ProxyFactory(target).getProxyInstance();

        try {
            internet.connectTo("so.cn");
            internet.connectTo("qq.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

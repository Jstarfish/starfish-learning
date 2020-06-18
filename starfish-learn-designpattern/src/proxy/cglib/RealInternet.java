package proxy.cglib;

/**
 * @description: 不需要实现接口
 * @author: starfish
 * @create: 2020-06-17 18:19
 **/
public class RealInternet{

    public void connectTo(String serverHost) {
        System.out.println("Connecting to "+ serverHost);
    }
}

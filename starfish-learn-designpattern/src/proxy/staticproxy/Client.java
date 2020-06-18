package proxy.staticproxy;

/**
 * @description:
 * @author: starfish
 * @create: 2020-06-17 18:28
 **/
public class Client {

    public static void main(String[] args) {
        Internet internet = new ProxyInternet(new RealInternet());
        try {
            internet.connectTo("360.cn");
            internet.connectTo("qq.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

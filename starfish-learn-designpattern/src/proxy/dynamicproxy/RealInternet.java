package proxy.dynamicproxy;

import proxy.staticproxy.Internet;

/**
 * @description:
 * @author: starfish
 * @create: 2020-06-17 18:19
 **/
public class RealInternet implements Internet{

    @Override
    public void connectTo(String serverHost) throws Exception {
        System.out.println("Connecting to "+ serverHost);
    }
}

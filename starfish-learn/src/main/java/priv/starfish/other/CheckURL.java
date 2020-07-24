package priv.starfish.other;

import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jiahaixin
 * @date: 2019/7/8 10:11
 * @description: 一个网址可能有多个ip,所以用 InetAddress[] addresses =InetAddress.getAllByName(host);
 */
public class CheckURL {


    public static void main(String[] args) throws URISyntaxException, UnknownHostException {
        List<String> whitelist = Arrays.asList("AA", "BNB");


        //String url = "http://d.openapi.dmp.360.cn/xml/pinduoduo_ddk_goods_old/index.xml";
        String url = "http://dmp.360.cn/tags/main/tags-mobile-market";
        URI uri =new URI(url);

        String host = uri.getHost();
        System.out.println(host +"==="+uri.getPath());


        InetAddress address1 = InetAddress.getLocalHost();
        System.out.println("localhost:"+address1);

        InetAddress inetAddress = InetAddress.getByName(host);
        System.out.println("inetnet:"+inetAddress.getHostAddress());

        try {

            InetAddress[] addresses =InetAddress.getAllByName(host);
            for (InetAddress address : addresses) {
                String ip = address.getHostAddress();
                System.out.println(ip);
                if (whitelist.contains(host)) {
                    continue;
                } else if (ip.startsWith("10.") || ip.startsWith("172.16.") || ip.startsWith("192.168.")
                        || ip.equals("127.0.0.1") || ip.equals("localhost")) {
                    throw new URISyntaxException(url,
                            "Internal ip address is forbidden.");
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }


}

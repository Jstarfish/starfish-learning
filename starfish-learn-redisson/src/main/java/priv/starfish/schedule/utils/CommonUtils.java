package priv.starfish.schedule.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author: jiahaixin
 * @date: 2018/12/28 18:08
 * @description:
 */
public class CommonUtils {



    public static final String DateFormat4 = "yyyy-MM-dd HH:mm:ss";

    public static String getCurrentDate() {
        SimpleDateFormat sf = new SimpleDateFormat(DateFormat4);
        return sf.format(new Date());
    }

    public static String getHost() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            return addr.getHostAddress(); //获取本机ip
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getInet4Address() {
        Enumeration<NetworkInterface> nis;
        String ip = null;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
            for (; nis.hasMoreElements();) {
                NetworkInterface ni = nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                for (; ias.hasMoreElements();) {
                    InetAddress ia = ias.nextElement();
                    //ia instanceof Inet6Address && !ia.equals("")
                    if (ia instanceof Inet4Address && !ia.getHostAddress().equals("127.0.0.1")) {
                        ip = ia.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ip;
    }
}

package proxy.staticproxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: VPN
 * @author: starfish
 * @create: 2020-06-17 18:20
 **/
public class ProxyInternet implements Internet {


    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static
    {
        bannedSites = new ArrayList<String>();
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("lnm.com");
    }

    @Override
    public void connectTo(String serverhost) throws Exception {
        if(bannedSites.contains(serverhost.toLowerCase()))
        {
            throw new Exception("Access Denied");
        }

        internet.connectTo(serverhost);
    }
}

package priv.starfish.multiValueMap;


import org.apache.commons.collections4.map.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author: jiahaixin
 * @date: 2019/5/22 11:45
 * @description:
 */
public class Test {

    public static void main(String[] args) throws IOException {

        MultiValueMap mailMap = new MultiValueMap();
        mailMap.put("number", "1");
        mailMap.put("number", "30");
        mailMap.put("name", "wang");
        mailMap.put("card", "12344");
        mailMap.put("card", "65432");

        Collection mapcoll = null;
        mapcoll = mailMap.getCollection("card");
        Iterator ii = mapcoll.iterator();
        while (ii.hasNext()) {
            String mailValue = (String) ii.next();
            System.out.println(mailValue);
        }
    }


}

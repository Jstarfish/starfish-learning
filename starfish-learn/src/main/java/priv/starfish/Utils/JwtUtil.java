package priv.starfish.Utils;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.RandomStringUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

/**
 * @author: jiahaixin
 * @date: 2019/7/26 15:45
 * @description:
 */
public class JwtUtil {


    public static void main(String[] args) {

        System.out.println(UUID.randomUUID().toString().replace("-", ""));


        System.out.println(RandomStringUtils.randomAlphanumeric(32));


        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("1", "a");
        map1.put("2", "b");
        map1.put("3", "c");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("1", "aa");
        map2.put("2", "b");
        map2.put("3", "cc");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).get("1").equals("aa")) {
                list.remove(i);
            }
        }

        for (Map<String, String> stringMap : list) {

            System.out.println(stringMap.values());

//            for (Map.Entry<String, String> entry : stringMap.entrySet()) {
//                System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//            }
        }


    }
}


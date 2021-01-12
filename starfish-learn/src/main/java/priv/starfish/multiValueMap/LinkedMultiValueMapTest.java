package priv.starfish.multiValueMap;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

/**
 * @author: jiahaixin
 * @date: 2019/5/22 11:52
 * @description:
 */
public class LinkedMultiValueMapTest {


    public static void main(String[] args) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("k1", "v1");
        map.add("k1", "v2");

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getValue());

            for (String value : entry.getValue()) {
                System.out.println(value);
            }
        }
    }
}

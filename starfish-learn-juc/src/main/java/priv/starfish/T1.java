package priv.starfish;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-20 20:58
 **/
public class T1 {

    volatile int i = 0;

    public void add(){
        i ++;
    }

    public static Map<String, String> PRODUCT_DATA_MAP = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        System.out.println(PRODUCT_DATA_MAP.get(null));

    }
}

package net.lazyegg.list;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: starfish
 * @data: 2020-04-18 20:55
 **/
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.put("k1","v1");
        map.get("k1");
    }
}

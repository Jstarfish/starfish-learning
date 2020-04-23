package net.lazyegg.list;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @description:
 * @author: starfish
 * @data: 2020-04-17 10:58
 **/
public class HashtableDemo {

    public static void main(String[] args) {
        Hashtable<String, Integer> map = new Hashtable<>();
        map.put("历史", 60);
        map.put("政治", 80);
        map.put("语文",80);
        map.put("数学",100);
        map.put("英语",100);
        map.put(null,10);

        for(Map.Entry<String, Integer> entry : map.entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

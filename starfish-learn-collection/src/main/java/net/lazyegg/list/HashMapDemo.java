package net.lazyegg.list;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @description:
 * @author: starfish
 * @data: 2020-04-17 10:58
 **/
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("历史", 60);
        map.put("政治", 80);
        map.put("语文",80);
        map.put("数学",100);
        map.put("英语",100);
        map.put(null,10);

        Hashtable<String,Integer> hashtable = new Hashtable<>();
        hashtable.put("java",100);
        hashtable.put("python",90);
        hashtable.put("go",60);

        System.out.println(185 & 129);
        System.out.println(Integer.toBinaryString(185 & 16));
        System.out.println(Integer.toBinaryString(15));

        for(Map.Entry<String, Integer> entry : map.entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //Iterator iterator
    }
}

package others;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

/**
 * @description: 集合类学习
 * @author: starfish
 * @create: 2020-04-16 10:36
 **/
public class CollectionDemo {


    public static void main(String[] args) {
        Queue<String> queue = new ArrayBlockingQueue<>(2);

        List<String> arrayList = new ArrayList<>(2);

        arrayList.add("aa");

        List<String> vector = new Vector<>(10, 20);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("bb");

        Set<String> set = new HashSet<>();

        Map<String, String> map = new HashMap<>();

        map.put("a", "aa");
        map.put("a", "bb");
        map.put("c", "cc");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));

        }

    }

}

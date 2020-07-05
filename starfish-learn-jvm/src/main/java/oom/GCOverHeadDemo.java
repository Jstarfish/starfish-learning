package oom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @description: -Xmx12m -XX:+PrintGCDetails -XX:+UseParallelGC
 * @author: starfish
 * @data: 2020-07-05 15:50
 **/
public class GCOverHeadDemo {


    public static void main(String args[]) throws Exception {
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "value");
        }
    }

//    public static void main(String[] args) {
//        List list = new ArrayList();
//        Random r = new Random();
//        while (true){
//            list.add(r.nextInt());
//            System.out.println(r.nextInt());
//        }
//    }
}

package priv.starfish;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @description: 集合类不安全问题
 * @author: starfish
 * @data: 2020-04-01 10:25
 **/
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        //listNotSafe();

        //setNotSafe();
        mapNotSafe();


    }

    private static void mapNotSafe() {
        //Map<String,String> map = new HashMap<>();
        Map<String,String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        //List<String> list = Arrays.asList("a","b","c");

        //list.forEach(System.out::println);


        //List<String> list = new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

        /**
         * 多次运行，会出现 ConcurrentModificationException 异常
         *
         * 导致原因：并发争抢修改导致，比如花名册签名时，大家都在抢着写，张三写完张字就被李四抢走，就会出现错乱，张三的名字就不完整了
         *
         *
         * 解决方法：
         *  1. List<String> list = new Vector<>();
         *  2. List<String> list = Collections.synchronizedList(new ArrayList<>());
         *  3. List<String> list = new CopyOnWriteArrayList<>();
         */

        /**
         *  写时复制
         *  CopyOnWrite 容器即写时复制的容器。
         *  往一个容器中添加元素的时候， 不直接往容器 Object[] 添加，而是先将容器 Object[] copy 一份出来，
         *  新的容器 Object[] newElements,然后往新的容器添加元素，添加完元素后，再将原容器的引用指向新容器，即setArray(newElements)
         *
         *  这样做的好处是，可以对copyOnWrite 容器进行并发读，而不需要加锁，因为当前容器不会添加任何新元素。
         *  CopyOnWrite 容器属于一种读写分离的思想，读和写操作不同的容器
         *
         */}


}

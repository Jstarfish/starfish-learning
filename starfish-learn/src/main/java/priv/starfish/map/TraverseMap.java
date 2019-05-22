package priv.starfish.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: jiahaixin
 * @date: 2019/3/12 11:50
 * @description: 遍历map方法对比
 */
public class TraverseMap {


    public static void main(String[] args) {
        Map<Integer, String> tempMap = new HashMap<Integer, String>();
        tempMap.put(11, "hadoop");
        tempMap.put(22, "hive");
        tempMap.put(33, "spark");

        //1. keyset遍历：如果只需要map的key或者value，用map的keySet或values方法无疑是最方便的
        for (Integer key : tempMap.keySet()) {
            System.out.println(key);
        }

        for (String value : tempMap.values()) {
            System.out.println(value);
        }

        //2. 通过keyset先获取到key,再通过get(key)获取value的值
        for (Integer key : tempMap.keySet()){
            System.out.println(key+":"+tempMap.get(key));
        }

        //3. entryset 通过对map entrySet的遍历，也可以同时拿到key和value，一般情况下，性能上要优于上一种,这一种也是最常用的遍历方法
        for (Map.Entry<Integer,String> entry : tempMap.entrySet()){
            System.out.println(entry.getKey()+"::"+entry.getValue());
        }

        //4. foreach可以用Interator代替 对于上面的几种foreach都可以用Iterator代替，其实foreach在java5中才被支持，foreach的写法看起来更简洁
        //但Iterator也有其优势：在用foreach遍历map时，如果改变其大小，会报错，但如果只是删除元素，可以使用Iterator的remove方法删除元素
        Iterator<Map.Entry<Integer, String>> it = tempMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,String> entry = it.next();
            System.out.println(entry.getKey()+":::"+entry.getValue());
        }

        //5. java8的 lambda
        tempMap.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

    }


}

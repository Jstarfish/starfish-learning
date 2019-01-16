package priv.starfish.other;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: jiahaixin
 * @date: 2018/11/6 15:11
 * @description:
 */
public class Test {


    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", 3);


        //String b = map.get("key3");

        //Short a = Short.parseShort((String)map.get("key3"));

        int a = (int) map.get("key3");

//        int b = Integer.valueOf((String) map.get("key3"));


        //int d = (int) map.get("key3");

        Calendar cal = Calendar.getInstance();

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
       // System.out.println(b);
       // System.out.println(c);


       /* List<String> list = new ArrayList<>();
        list.add("122");
        list.add("1232");

        int z = (int)list.get(1);*/


    }






  //  int b = (int)a;

}

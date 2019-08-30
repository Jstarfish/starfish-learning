package priv.starfish.other;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

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

        //System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
       // System.out.println(b);
       // System.out.println(c);

        User user1 = new User();
        user1.id = 1;
        user1.name="Tom";
        user1.birthday= new Date();

        User user2 = new User();
        user2.id = 2;
        user2.name="Amy";

        User user3 = new User();
        user3.id = 3;
        user3.name="Jim";


       List<User> list1 = new ArrayList<>();
        list1.add(user1);
        list1.add(user2);
        list1.add(user3);
        System.out.println(list1.size());

        List<User> list2 = new ArrayList<>();
        list2.add(user2);
        System.out.println(list2.size());

        List<User> list3 = new ArrayList<>();
        list3.add(user3);
        System.out.println(list3.size());


        list2.addAll(list3);
        System.out.println("addAll====="+list2.size());

        //list1.removeAll(list2);
        CollectionUtils.removeAll(list1,list2);
        System.out.println("removeAll==="+list1.size());






    }


   static class User{
        public int id;
        public String name;
        public Date birthday;

       @Override
       public boolean equals(Object o) {
           if (this == o) return true;
           if (o == null || getClass() != o.getClass()) return false;
           User user = (User) o;
           return id == user.id &&
                   Objects.equals(name, user.name) &&
                   Objects.equals(birthday, user.birthday);
       }

       @Override
       public int hashCode() {
           return Objects.hash(id, name, birthday);
       }
   }



  //  int b = (int)a;

}

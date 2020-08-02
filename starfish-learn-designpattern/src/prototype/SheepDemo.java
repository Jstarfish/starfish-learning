package prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: starfish
 * @data: 2020-08-02 10:56
 **/
public class SheepDemo {

    static List<Sheep> sheepList = new ArrayList<>();

    public static void main(String[] args) {


//        for (int i = 0; i < 10; i++) {
//            Sheep sheep = new Sheep("肖恩"+i+"号",2+i,"白色");
//            System.out.println(sheep.hashCode());
//            System.out.println(sheep.toString());
//        }

        // clone 的方式

        Sheep s = new Sheep();
        s.setName("sss");

        s.friend = new Sheep();
        s.friend.setName("喜洋洋");

        Sheep s1 = s.clone();
        System.out.println(s == s1);
        System.out.println(s.hashCode()+"---"+s.clone().hashCode());

        System.out.println(s.friend == s1.friend);
        System.out.println(s.friend.hashCode() + "---" +s1.friend.hashCode());


        Goat goat = new Goat();
        goat.setName("山羊");
        goat.setAge(3);
        goat.setColor("灰色");
        for (int i = 0; i < 5; i++) {
            sheepList.add(goat.clone());
        }

        Lamb lamb = new Lamb();
        lamb.setName("羔羊");
        lamb.setAge(2);
        lamb.setColor("白色");

        Lamb lamb1 = (Lamb) lamb.clone();

        System.out.println(lamb.hashCode()+"--"+lamb1.hashCode());
        System.out.println(lamb.hashCode()+"--"+lamb.clone().hashCode());
        for (int i = 0; i < 5; i++) {
            sheepList.add(lamb.clone());
            System.out.println(lamb.hashCode()+","+lamb.clone().hashCode());
            System.out.println(lamb == lamb.clone());
        }

        for (Sheep sheep : sheepList) {
            System.out.println(sheep.toString());
        }

//        Sheep sheep = new Sheep("肖恩",2,"白色");
//        for (int i = 0; i < 10; i++) {
//            Sheep s = sheep.clone();
//            s.setName(i+"号");
//            System.out.println(sheep.clone().toString());
//        }



//        System.out.println("===克隆小样肖恩开始===");
//
//
//
//
//        Goat goat = new Goat("肖恩",2,"白色");
//
//
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);

    }

//
//    public static void flock(){
//        Goat goat = new Goat();
//        goat.setName("山羊");
//        goat.setAge(3);
//        goat.setColor("灰色");
//        for (int i = 0; i < 5; i++) {
//            sheepList.add(goat.clone());
//        }
//
//        Lamb lamb = new Lamb();
//        lamb.setName("羔羊");
//        lamb.setAge(2);
//        lamb.setColor("白色");
//        for (int i = 0; i < 5; i++) {
//            sheepList.add(goat.clone());
//        }
//    }



}

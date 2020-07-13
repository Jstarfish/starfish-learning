package priv.starfish.object;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: starfish
 * @data: 2020-07-12 22:14
 **/
public class ObjectCreation {


    public static void main(String[] args) {

        try {

            // new 方式创建对象
            Person p = new Person();
            p.sayHi();


            // 利用反射，通过使用Class类的newInstance方法

            //获取类对象
            Class aClass = Class.forName("priv.starfish.object.Person");
            Person p1 = (Person) aClass.newInstance();
            p1.sayHi();

            //使用Constructor类的newInstance方法
            //获取构造器
            Constructor constructor = aClass.getConstructor();
            Person p2 = (Person) constructor.newInstance();
            p2.sayHi();

            //java8 去掉了 clone
            Person p3 = (Person) p.clone();
            p3.sayHi();


            /*
             * 反序列化的方式创建对象
             **/
            //准备一个文件用于存储该对象的信息
//            File f = new File("person.obj");
//            FileOutputStream fos = new FileOutputStream(f);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            //序列化对象，写入到磁盘中
//            oos.writeObject(p);
//            //反序列化
//            FileInputStream fis = new FileInputStream(f);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            //反序列化对象
//            Person p4 = (Person) ois.readObject();
//            p4.sayHi();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

package net.lazyegg.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: starfish
 * @data: 2020-04-19 19:16
 **/
public class ComparableDemo {


    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(18,"Tom"));
        list.add(new Person(22,"Amy"));
        list.add(new Person(20,"Jim"));
        list.add(new Person(16,"Ben"));

        Collections.sort(list);
        for (Person student : list) {
            System.out.println(student.toString());
        }
    }

}


class Person implements Comparable<Person>{
    String name;
    int age;

    @Override
    public int compareTo(Person o) {
        return o.age - this.age; //倒排
    }

    Person(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

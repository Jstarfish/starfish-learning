package net.lazyegg.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @author: starfish
 * @data: 2020-04-19 19:43
 **/
public class ComparatorDemo {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(18,"Tom"));
        list.add(new Student(22,"Amy"));
        list.add(new Student(20,"Jim"));
        list.add(new Student(16,"Ben"));

        AgeComparator comparator = new AgeComparator();
        Collections.sort(list,comparator);
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

}

class AgeComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        return s1.age-s2.age;
    }
}

class Student{
    int age;
    String name;

    Student(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/20 11:10
 */
public class SortTest {

    public static void main(String[] args) {

        List<Student> studentList= Arrays.asList(new Student(1,"ziwen1",10),new Student(2,"aiwen2",38),new Student(3,"biwen3",28));

        List<Student> studentList3=studentList.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());//根据年龄自然顺序

        for (Student student : studentList3) {
            System.out.println(student);
        }

    }
}

package priv.starfish;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-12 15:44
 **/
public class AtomicRefrenceDemo {

    public static void main(String[] args) {

        User tom = new User("tom",18);
        User jim = new User("jim",20);

        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(tom);

        System.out.println(userAtomicReference.compareAndSet(tom, jim)+"\t"+userAtomicReference.get().toString());
        System.out.println(userAtomicReference.compareAndSet(tom, jim)+"\t"+userAtomicReference.get().toString());

    }


}

class User{
    String name;
    int age;

    public User(String tom, int i) {
    }
}
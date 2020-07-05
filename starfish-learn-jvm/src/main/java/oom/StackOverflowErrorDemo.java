package oom;

/**
 * @description: java.lang.StackOverflowError
 * @author: starfish
 * @data: 2020-05-05 15:43
 **/
public class StackOverflowErrorDemo {

    StackOverflowErrorDemo demo = new StackOverflowErrorDemo();

    public static void main(String[] args) {

        javaKeeper();
    }

    private static void javaKeeper() {

        javaKeeper();
    }

    void s() {
        demo.s();
    }
}

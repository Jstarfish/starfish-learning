package oom;

/**
 * @description:
 * @author: starfish
 * @data: 2020-05-05 15:43
 **/
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackoverflowError();
    }

    private static void stackoverflowError() {
        stackoverflowError();
    }
}

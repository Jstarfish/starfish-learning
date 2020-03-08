package priv.starfish.jvm.exception;

/**
 * @description: 虚拟机栈异常:StackOverflowError,可以通过-Xss 设置栈大小，查看两次输出数量
 * @author: starfish
 * @data: 2020-02-25 22:51
 **/
public class StackErrorTest {

    private static int count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}

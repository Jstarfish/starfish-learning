package classloader;

public class StackFeameTest {

    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        System.out.println("method1()开始执行");
        method2();
        System.out.println("method1()结束执行");
    }

    private static void method2() {
        System.out.println("method2()开始执行");
        method3();
        System.out.println("method2()即将执行");
    }

    private static int method3() {
        System.out.println("method2()开始执行");
        int i = 1;
        System.out.println("method2()即将执行");
        return i;
    }
}

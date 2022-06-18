package classloader;


/**
 * 类的主动加载和被动加载
 */
public class NotInitialization {

    public static void main(String[] args) {

        System.out.println(SubClass.value); //只输出SupperClass int 123,不会输出SubClass init
    }

}


class SuperClass {

    static {
        System.out.println("SupperClass init");
    }

    public static int value = 123;
}


class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init");
    }

}

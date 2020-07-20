package priv.starfish.object;

/**
 * @description: 类的主动使用和被动使用
 * @author: starfish
 * @create: 2020-07-16 17:15
 **/
public class NotInitialization {
    public static void main(String[] args) {
        //只输出SupperClass int 123,不会输出SubClass init
        //对于静态字段，只有直接定义这个字段的类才会被初始化
        System.out.println(SubClass.value);
    }
}

class SuperClass {

    public static int value = 123;

    static {
        System.out.println("SupperClass init");
    }
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }
}

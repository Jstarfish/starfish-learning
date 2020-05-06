package reference;

/**
 * @description: 强引用
 * @author: starfish
 * @data: 2020-05-06 21:27
 **/
public class StrongRefenenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(o2);
    }
}

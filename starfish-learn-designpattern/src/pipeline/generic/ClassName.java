package pipeline.generic;

/**
 * @description:
 * @author: starfish
 * @date: 2021/5/25 21:08
 */
public class ClassName<T> {

    void show_1(T t) {
        System.out.println("show_1  " + t.toString());
    }

    <E> void show_2(E e) {
        System.out.println("show_2  " + e.toString());
    }

    <T> void show_3(T t) {
        System.out.println("show_3  " + t.toString());
    }
    public static void main(String[] args) {
        ClassName<Fruit> o = new ClassName<Fruit>();//创建一个ClassName实例，限定它的类型为Fruit
        Fruit f = new Fruit();
        Apple a = new Apple();
        Dog dog = new Dog();
        System.out.println("-----------------演示一下show_1------------------");
        o.show_1(f);
        o.show_1(a);
        //这是不能编译通过的，因为此时o对象已限定为Fruit类
        //o.show_1(dog);
        System.out.println("-----------------演示一下show_2-----------------");
        o.show_2(f);
        o.show_2(a);
        o.<Dog>show_2(dog);
        System.out.println("-----------------演示show_3-------------------");
        o.show_3(f);
        o.show_3(a);
        o.<Dog>show_3(dog);
    }
}

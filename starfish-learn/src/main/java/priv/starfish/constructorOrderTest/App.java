package priv.starfish.constructorOrderTest;

/**
 * @author: jiahaixin
 * @date: 2019/9/24 10:42
 * @description:
 *  父类的静态内容—>子类的静态内容—>父类非静态代码块—>父类构造器—>子类非静态代码块—>子类构造器
 *
 */
public class App {
    public static void main(String[] args) {
        App2 app2=new App2();
    }

    int a =110;//Foo的成员变量
    public App() {
        System.out.println("我是父类的构造方法");
        add();
    }
    public void add() {
        System.out.println("调用我了吗？");
        a++;
        System.out.println(a);
    }
}
class App2 extends App{
    int a =100;
    public App2() {
        System.out.println(a);
    }
    @Override
    public void add() {
        System.out.println("重写了父类的add方法");
        System.out.println(a);
        a++;
        System.out.println(a);
    }
}

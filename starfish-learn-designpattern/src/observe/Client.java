package observe;

/**
 * @description:
 * @author: starfish
 * @create: 2020-03-17 14:07
 **/
public class Client {

    public static void main(String[] args){
        Subject sub = new ConcreteSubject();
        sub.addObserver(new ConcreteObserver1()); //添加观察者1
        sub.addObserver(new ConcreteObserver1()); //添加观察者2
        sub.doSomething();
        sub.notify();
    }

}

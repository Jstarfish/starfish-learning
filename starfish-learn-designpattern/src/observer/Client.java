package observer;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-18 10:49
 **/
public class Client {

    public static void main(String[] args){
        Subject sub = new ConcreteSubject();
        sub.addObserver(new ConcreteObserver1()); //添加观察者1
        sub.addObserver(new ConcreteObserver2()); //添加观察者2
        sub.doSomething();
    }
}

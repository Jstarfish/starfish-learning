package observe;

/**
 * @description:
 * @author: starfish
 * @create: 2020-03-17 14:05
 **/
public class ConcreteSubject extends Subject{

    @Override
    public void doSomething() {
        System.out.println("被观察者事件反生");
        this.notifyObserver();
    }
}

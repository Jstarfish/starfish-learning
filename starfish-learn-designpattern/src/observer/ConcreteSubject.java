package observer;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-18 10:40
 **/
public class ConcreteSubject extends Subject {
    @Override
    public void doSomething() {
        System.out.println("被观察者反生改变");
        this.notifyObserver();
    }
}

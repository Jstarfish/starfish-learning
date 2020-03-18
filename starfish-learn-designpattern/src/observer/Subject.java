package observer;

import java.util.Vector;

/**
 * @description: 观察目标，被观察者
 * @author: starfish
 * @data: 2020-03-18 10:21
 **/
abstract class Subject {

    private Vector<Observer> observers = new Vector<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void deleteObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyObserver(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public abstract void doSomething();

}

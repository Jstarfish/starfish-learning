package observe;

import java.util.Vector;

/**
 * @description:
 * @author: starfish
 * @create: 2020-03-17 13:54
 **/
abstract class Subject {

    private Vector<Observer> obs = new Vector();

    public void addObserver(Observer obs){
        this.obs.add(obs);
    }
    public void delObserver(Observer obs){
        this.obs.remove(obs);
    }
    protected void notifyObserver(){
        for(Observer o: obs){
            o.update();
        }
    }
    public abstract void doSomething();
}

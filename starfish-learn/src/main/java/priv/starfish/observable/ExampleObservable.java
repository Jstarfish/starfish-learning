package priv.starfish.observable;

import javafx.beans.InvalidationListener;

import java.util.Observable;

/**
 * @author: jiahaixin
 * @date: 2019/1/15 18:22
 * @description: 被观察者
 */
public class ExampleObservable extends Observable {

    int data = 0;

    public void setData(int data) {
        this.data = data;

        this.setChanged();  //标记此 Observable对象为已改变的对象
        this.notifyObservers(); //通知所有的观察者，也可以指定某个观察者

    }


}

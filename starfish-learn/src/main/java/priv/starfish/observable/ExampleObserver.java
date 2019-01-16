package priv.starfish.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: jiahaixin
 * @date: 2019/1/15 18:27
 * @description: 观察者
 */
public class ExampleObserver implements Observer {


    //有被观察者发生变化，自动调用对应观察者的update方法
    @Override
    public void update(Observable o, Object arg) {

        //通过强制类型转换获取被观察者对象
        ExampleObservable exampleObservable = (ExampleObservable) o;

        System.out.println("example.data changed, the new value of data is " + exampleObservable.data);

    }
}

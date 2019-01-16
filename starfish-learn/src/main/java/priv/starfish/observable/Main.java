package priv.starfish.observable;

/**
 * @author: jiahaixin
 * @date: 2019/1/15 18:30
 * @description:
 */
public class Main {


    public static void main(String[] args) {
        ExampleObservable exampleObservable = new ExampleObservable();
        //给example这个被观察者添加观察者，允许添加多個观察者
        exampleObservable.addObserver(new ExampleObserver());

        exampleObservable.setData(131);
        exampleObservable.setData(0);
        exampleObservable.setData(-1314);
    }
}

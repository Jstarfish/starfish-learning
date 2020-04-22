package observe;

/**
 * @description:
 * @author: starfish
 * @create: 2020-03-17 14:00
 **/
public class ConcreteObserver2 implements Observer{

    public void update() {
        System.out.println("观察者2收到信息，并进行处理。");
    }
}

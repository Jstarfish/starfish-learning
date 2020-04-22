package observe;

/**
 * @description:
 * @author: starfish
 * @create: 2020-03-17 14:00
 **/
public class ConcreteObserver1 implements Observer{

    public void update() {
        System.out.println("观察者1收到信息，并进行处理。");
    }
}

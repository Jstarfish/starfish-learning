package observer;

/**
 * @description: 具体的观察者
 * @author: starfish
 * @data: 2020-03-18 10:46
 **/
class ConcreteObserver1 implements Observer {
    @Override
    public void update() {
        System.out.println("观察者1收到信息，并进行处理");
    }
}


class ConcreteObserver2 implements Observer {
    @Override
    public void update() {
        System.out.println("观察者2收到信息，并进行处理");
    }
}
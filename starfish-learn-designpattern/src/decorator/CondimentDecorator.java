package decorator;

/**
 * @description: 调料抽象类，装饰者类
 * @author: starfish
 * @data: 2020-03-23 21:15
 **/
public abstract class CondimentDecorator extends Pancake {

    // 持有组件对象
    protected Pancake pancake;

    public CondimentDecorator(Pancake pancake){
        this.pancake = pancake;
    }

    public abstract String getDescription();

}

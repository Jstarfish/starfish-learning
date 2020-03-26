package decorator;

/**
 * @description: 鸡蛋装饰器
 * @author: starfish
 * @data: 2020-03-24 12:37
 **/
public class Egg extends CondimentDecorator {

    //Pancake pancake;

    public Egg(Pancake pancake){
        super(pancake);
    }

    @Override
    public String getDescription() {
        return pancake.getDescription() + "加鸡蛋";
    }

    @Override
    public double cost() {
        return pancake.cost() + 1;
    }
}

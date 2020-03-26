package decorator;

/**
 * @description: 火腿肠装饰器
 * @author: starfish
 * @data: 2020-03-24 12:40
 **/
public class Sausage extends CondimentDecorator{


    public Sausage(Pancake pancake){
        super(pancake);
    }
    @Override
    public String getDescription() {
        return pancake.getDescription() + "加火腿";
    }

    @Override
    public double cost() {
        return pancake.cost() + 2;
    }
}

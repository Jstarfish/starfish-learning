package decorator;

/**
 * @description: 具体的被装饰者，这里是煎饼果子，还可以有鸡蛋灌饼、手抓饼等其他被装饰者
 * @author: starfish
 * @data: 2020-03-23 21:12
 **/
public class Battercake extends Pancake {
    @Override
    public double cost() {
        return 8;
    }

    public Battercake(){
        description = "煎饼果子";
    }
}

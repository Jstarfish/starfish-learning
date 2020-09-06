package template;

/**
 * @description:
 * @author: starfish
 * @create: 2020-09-04 18:16
 */
public abstract class Drinks {

    void boilWater() {
        System.out.println("将水煮沸");
    }

    abstract void brew();

    void pourInCup() {
        System.out.println("倒入杯子");
    }

    abstract void addCondiments();

    public final void makingDrinks() {

        //热水
        boilWater();

        //冲泡
        brew();

        //倒进杯子
        pourInCup();

        //如果顾客需要，才加料
        if (customerLike()) {
            addCondiments();
        }
    }

    //定义一个空的缺省方法，只返回 true
    boolean customerLike() {
        return true;
    }

}

package decorator;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-24 12:46
 **/
public class Client {

    public static void main(String[] args) {

        //买一个普通的煎饼果子
        Pancake battercake = new Battercake();
        System.out.println(battercake.getDescription() + "花费："+battercake.cost() + "元");

        //买一个加双蛋的煎饼果子
        Pancake doubleEgg = new Battercake();
        doubleEgg = new Egg(doubleEgg);
        doubleEgg = new Egg(doubleEgg);
        System.out.println(doubleEgg.getDescription() + "花费" + doubleEgg.cost() + "元");

        //加火腿和鸡蛋
        Pancake battercakePlus = new Battercake();
        battercakePlus = new Egg(battercakePlus);
        battercakePlus = new Sausage(battercakePlus);
        System.out.println(battercakePlus.getDescription() + "花费" + battercakePlus.cost() + "元");

    }
}

package template;

import java.util.Arrays;

/**
 * @description:
 * @author: starfish
 * @create: 2020-09-04 18:17
 */
public class TemplatePatternDemo {

    public static void main(String[] args) {

//        Drinks coffee = new Coffee();
//        coffee.makingDrinks();
//        System.out.println();
//        Drinks tea = new Tea();
//        tea.makingDrinks();

        Coffee[] coffees = {new Coffee("星冰乐",38),
                            new Coffee("拿铁",32),
                            new Coffee("摩卡",35)};

        Arrays.sort(coffees);

        for (Coffee coffee1 : coffees) {
            System.out.println(coffee1);
        }

    }

}

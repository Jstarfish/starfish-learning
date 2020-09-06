package template;

/**
 * @description:
 * @author: starfish
 * @create: 2020-09-04 18:17
 */
public class Tea extends Drinks {

    @Override
    void brew() {
        System.out.println("冲茶叶");
    }

    @Override
    void addCondiments() {
        System.out.println("加柠檬片");
    }
}

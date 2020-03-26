package decorator;

/**
 * @description: 组件对象的接口
 * @author: starfish
 * @data: 2020-03-23 21:06
 **/
public abstract class Pancake {

    String description = "普通煎饼";

    public String getDescription(){
        return description;
    }

    public abstract double cost();

}

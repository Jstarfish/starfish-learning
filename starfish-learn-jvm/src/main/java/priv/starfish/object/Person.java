package priv.starfish.object;


/**
 * @description:
 * @author: starfish
 * @data: 2020-07-12 21:45
 **/
public class Person implements Cloneable {

    int id = 1008;
    String name;
    Department department;

    {
        name = "匿名用户";   //name赋值为字符串常量
    }

    public void sayHi(){
        System.out.println("泥豪！！！");
    }


    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

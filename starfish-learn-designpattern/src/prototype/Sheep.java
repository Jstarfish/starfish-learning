package prototype;

import lombok.*;

import java.util.Objects;

/**
 * @description:
 * @author: starfish
 * @data: 2020-08-02 11:04
 **/
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
class Sheep implements Cloneable {
    private String name;
    private int age;
    private String color;

    //是对象, 克隆是会如何处理, 默认是浅拷贝
    public Sheep friend;

    @Override
    protected Sheep clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }

    public Sheep(String name,int age,String color){
        this.name = name;
        this.age = age;
        this.color = color;

    }

}

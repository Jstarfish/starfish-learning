package priv.starfish.prototype;

/**
 * @description:
 * @author: starfish
 * @data: 2020-08-02 18:40
 **/
class Sheep implements Cloneable {
    private String name;
    private int age;
    private String color;

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

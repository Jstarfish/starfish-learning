package template;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: starfish
 * @create: 2020-09-04 18:16
 */
public class Coffee extends Drinks implements Comparable{


    @Override
    void brew() {
        System.out.println("冲咖啡粉");
    }

    @Override
    void addCondiments() {
        System.out.println("加奶加糖");
    }

    boolean customerLike() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    //处理用户的输入
    private String getUserInput() {
        String answer = null;
        System.out.println("您想要加奶加糖吗？输入 YES 或 NO");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }

    private String name;
    private double price;

    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public int compareTo(Object o) {
        Coffee coffee = (Coffee) o;
        if(this.price < (coffee.price)){
            return -1;
        }else if(this.price == coffee.price){
            return 0;
        }else{
            return 1;
        }
    }

    public Coffee() {
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

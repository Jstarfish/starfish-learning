package prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 羔羊
 * @author: starfish
 * @data: 2020-08-02 16:44
 **/
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Lamb extends Sheep{

    public void graze() {
        System.out.println("羔羊去吃草");
    }

}

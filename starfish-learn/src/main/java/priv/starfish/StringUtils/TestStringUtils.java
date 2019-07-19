package priv.starfish.StringUtils;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author: jiahaixin
 * @date: 2019/7/18 18:39
 * @description: StringUtils工具类试验
 */
public class TestStringUtils {


    public static void main(String[] args) {


        System.out.println(StringUtils.isEmpty("    "));       //false

        System.out.println(StringUtils.isNotBlank("     "));    //false

        System.out.println(StringUtils.trim("  starfis h  "));      //starfis h

        System.out.println("trim:"+StringUtils.trim(" \b \t \n \f \r "));   //trim:

        System.out.println("trim1:"+StringUtils.trim(" \n\tss \b"));   //trim1:ss

        System.out.println("strip:::"+StringUtils.strip(" \b \t \n \f \r "));  //   strip:: （\b退格后 少了个：）

        System.out.println("strip1:"+StringUtils.strip(" \n\tss \b"));   //strip1:ss

        System.out.println(StringUtils.stripStart("starfish","star"));    //fish

        System.out.println(StringUtils.indexOf("starfish","st"));    //0

        System.out.println(StringUtils.compare("starfish","starfish"));   //0

        System.out.println(StringUtils.contains("starfish","star"));   //true

        System.out.println(StringUtils.remove("starfish","star"));  //fish

        System.out.println(StringUtils.substring("starfish",4));   //fish

        System.out.println(StringUtils.left("starfish",4));   //star

        System.out.println(StringUtils.equals("star",null));          //false

        System.out.println(StringUtils.join(Arrays.asList("star","fish")));   //[star, fish]

        System.out.println(StringUtils.join(new String[]{"a","b"},","));

        System.out.println(StringUtils.replace("staafish","aa","ar"));

        for (String st : StringUtils.split("s.t.a.r",".")) {
            System.out.println(st);          //s   t   a   r
        }

        System.out.println(StringUtils.upperCase("Starfish"));   //STARFISH

        System.out.println(StringUtils.capitalize("starfiSh"));  //StarfiSh

        System.out.println(StringUtils.uncapitalize("StarfiSh"));  //starfiSh

        System.out.println(StringUtils.isNumeric("12"));  //true





    }
}

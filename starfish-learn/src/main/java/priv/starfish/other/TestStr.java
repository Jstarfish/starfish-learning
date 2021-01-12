package priv.starfish.other;

/**
 * @author: jiahaixin
 * @date: 2019/1/30 15:07
 * @description:
 */
public class TestStr {

    public static void main(String[] args) {
        String flag = "China_southern_airlines_pcsssss";
        System.out.println(flag.indexOf("l"));

        System.out.println("China_southern_airlines_".length());

        System.out.println(flag.substring("China_southern_airlines_".length()));


        String str = "abcdefg";
        System.out.println(str.substring(str.indexOf("c") + 1));
    }


}

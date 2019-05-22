package priv.starfish.integer;

/**
 * @author: jiahaixin
 * @date: 2019/3/12 10:18
 * @description:
 */
public class TestValueOfAndParseInt {

    public static void main(String[] args) {
       /* String s1 = "1000";
        String s2 = "1000";

        int i1 = Integer.parseInt(s1);
        int i2 = Integer.valueOf(s2);

        if (i1 == i2) {
            System.out.println("Integer.parseInt(s1) == Integer.parseInt(s2)");
        }
    */
        String s = "1000";
        Integer i1 = Integer.valueOf(s);
        Integer i2 = Integer.valueOf(s);
        if (i1 == i2) { //两个对象相等
            System.out.println("i1 == i2");
        }
        if (i1.equals(i2)) { //两个对象中的value值相等
            System.out.println("i1.equals(i2)");
        }
    }
}

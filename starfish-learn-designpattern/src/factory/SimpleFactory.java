package factory;

import java.util.Calendar;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-10 22:31
 **/
public class SimpleFactory {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        System.out.println("year:" + calendar.get(Calendar.YEAR));

        System.out.println("month:" + calendar.get(Calendar.MONTH) + 1);
    }
}

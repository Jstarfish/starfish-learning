package priv.starfish.other;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author: jiahaixin
 * @date: 2019/3/15 16:55
 * @description:
 */
public class CalendarTest {


    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();


        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        c.set(Calendar.DAY_OF_WEEK, 4);


        System.out.println(sdf.format(c.getTime()));
    }
}

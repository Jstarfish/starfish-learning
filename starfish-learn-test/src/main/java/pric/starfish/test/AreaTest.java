package pric.starfish.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * @author Henry
 * @date 2021/12/15
 */
public class AreaTest {

        @Test
        @DisplayName("测试一个 point 是否在 Area 中")
        void test_Area() {
            Point A = new Point(10, 10, 1);
            Point B = new Point(-10, 10, 2);
            Point C = new Point(-10, -10, 3);
            Point D = new Point(10, -10, 4);
           // Area area = new Area(A, B, C, D);

           // assertTrue(area.contains(new Point(2, 2, 1)));

        }

}

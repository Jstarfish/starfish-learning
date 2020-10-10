package collection;

import java.util.Collections;
import java.util.HashMap;

/**
 * @description:
 * @author: starfish
 * @create: 2020-09-09 18:09
 */
public class Test {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        Collections.synchronizedMap(hashMap);
    }

}

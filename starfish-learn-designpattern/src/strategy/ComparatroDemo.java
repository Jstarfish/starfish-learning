package strategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 策略类在jdk的应用
 * @author: starfish
 * @date: 2021/4/26 17:46
 */
public class ComparatroDemo {

    public static void main(String[] args) {
        Integer[] data = {4,2,7,5,1,9};
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               if(o1 > o2){
                   return 1;
               } else {
                   return -1;
               }
            }
        };

        Arrays.sort(data,comparator);
        System.out.println(Arrays.toString(data));
    }

}

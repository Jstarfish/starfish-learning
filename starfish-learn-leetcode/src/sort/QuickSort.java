package sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Arrays;

/**
 * @description: 快速排序
 * @author: starfish
 * @create: 2020-06-02 16:44
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arrs = {6, 7, 5, 4,9,8};
        sort(arrs, 0, arrs.length - 1);
        System.out.println(Arrays.toString(arrs));
    }


    public static void sort(int[] arrs, int startIndex, int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        int pivotIndex  = partion(arrs,startIndex,endIndex);
        sort(arrs,startIndex,pivotIndex-1);
        sort(arrs,pivotIndex+1,endIndex);
    }


    public static int partion(int[] arrs, int startIndex, int endIndex) {

        int pirvot = arrs[startIndex];
        int mark = startIndex;
        for(int i=startIndex+1;i<arrs.length;i++){
            if(arrs[i]<pirvot){
                mark ++;
                int tmp = arrs[mark];
                arrs[mark] = arrs[i];
                arrs[i] = tmp;
            }
            System.out.println(Arrays.toString(arrs));
        }
        arrs[startIndex] = arrs[mark];
        arrs[mark] = pirvot;
        return mark;
    }


}

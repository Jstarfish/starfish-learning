package sort;

/**
 * @description: 冒泡排序
 * @author: starfish
 * @create: 2020-10-19 15:47
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arrs = new int[]{3,1,5,4,10,9};

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length - 1 -i; j++) {
                if(arrs[j] > arrs[j+1]){
                    int tmp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = tmp;

                    for (int arr : arrs) {
                        System.out.print(arr + " ");
                    }
                }
            }
        }
    }
}

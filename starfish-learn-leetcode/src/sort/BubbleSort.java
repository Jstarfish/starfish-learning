package sort;

/**
 * @description: 冒泡排序
 * @author: starfish
 * @create: 2020-06-01 20:49
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arrs = {1, 3, 4, 2, 6, 5};

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length - 1 - i; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
            }
        }

        for (int arr : arrs) {
            System.out.print(arr + " ");
        }
    }
}

package sort;

/**
 * @description: 选择排序
 * @author: starfish
 * @create: 2020-06-02 15:33
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] arrs = {5, 2, 4, 6, 1, 3};

        for (int i = 0; i < arrs.length; i++) {
            //最小元素下标
            int min = i;
            for (int j = i +1; j < arrs.length; j++) {
                if (arrs[j] < arrs[min]) {
                    min = j;
                }
            }
            //交换位置
            int temp = arrs[i];
            arrs[i] = arrs[min];
            arrs[min] = temp;
        }
        for (int arr : arrs) {
            System.out.println(arr);
        }
    }
}

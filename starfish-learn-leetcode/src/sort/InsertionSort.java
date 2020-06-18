package sort;

/**
 * @description: 插入排序
 * @author: starfish
 * @create: 2020-06-02 16:04
 **/
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int value = arr[i];
            int j = 0;//插入的位置
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];//移动数据
                } else {
                    break;
                }
            }
            arr[j+1] = value; //插入数据
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }



}

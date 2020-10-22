package sort;

import java.util.Arrays;

/**
 * @description: 快排
 * @author: starfish
 * @create: 2020-10-19 16:26
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arrs = new int[]{9, 8, 1, 5, 6, 3, 4};
        quickSort_1(arrs, 0, arrs.length - 1);

        System.out.println(Arrays.toString(arrs));

    }

    /**
     * 指针交换法
     * @param arrs
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int arrs[], int startIndex, int endIndex){
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex > endIndex) {
            return;
        }

        // 得到基准元素位置
        int pivotIndex = partition(arrs, startIndex, endIndex);

        // 用分治法递归数列的左右两部分
        quickSort(arrs, startIndex, pivotIndex - 1);
        quickSort(arrs, startIndex + 1, endIndex);
    }

    public static int partition(int[] arrs, int startIndex, int endIndex){
        int left = startIndex;
        int right = endIndex;
        int pivot = arrs[startIndex];

        while (left != right){
            //如果大于等于pivot，则指针向左移动；如果小于pivot，则right指针停止移动，切换到left指针
            if(left<right && arrs[right] >= pivot){
                right --;
            }

            if(left<right && arrs[left] <= pivot){
                left ++;
            }

            //交换left和right指向的元素
            if(left < right){
                int temp = arrs[left];
                arrs[left] = arrs[right];
                arrs[right] = temp;
            }
        }
        //pivot和指针重合点交换
        int temp = arrs[left];
        arrs[left] = arrs[right];
        arrs[right] = temp;

        return left;
    }


    /**
     * 挖坑法
     * @param arrs
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort_1(int arrs[], int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex > endIndex) {
            return;
        }

        // 得到基准元素位置
        int pivotIndex = partition_1(arrs, startIndex, endIndex);

        // 用分治法递归数列的左右两部分
        quickSort_1(arrs, startIndex, pivotIndex - 1);
        quickSort_1(arrs, startIndex + 1, endIndex);

    }

    public static int partition_1(int arrs[], int startIndex, int endIndex) {

        int pivot = arrs[startIndex];
        int left = startIndex;
        int right = endIndex;

        // 坑的位置，初始等于pivot的位置
        int pivotIndex = startIndex;

        //大循环在左右指针重合或者交错时结束
        while (right >= left) {
            while (right >= left) {
                if (arrs[right] < pivot) {
                    arrs[left] = arrs[right];
                    pivotIndex = right;
                    left++;
                    break;
                }
                right--;
            }

            while (right >= left) {
                if (arrs[left] > pivot) {
                    arrs[right] = arrs[left];
                    pivotIndex = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arrs[pivotIndex] = pivot;
        return pivotIndex;
    }

}

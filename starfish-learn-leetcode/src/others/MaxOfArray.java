package others;

/**
 * @author Henry
 * @date 2022/3/10
 * 两个递增的有序数组拼接到一起后，左边数组的最大值大于右边数组的最小值，
 * 两个数组中没有重复数字，比如 [1,2,6,9,3,5] 所求结果为 9, 要求复杂度logn
 */
public class MaxOfArray {

    public static void main(String[] args) {
        int[] arrs = new int[]{1,2,6,9,3,10};
        System.out.println(findMaxOfArray(arrs));

    }

    public static int findMaxOfArray(int[] arr){
        int max = -1;
        int i = 0, j = arr.length - 1, mid =(arr.length-1)/2;
        while(j - i > 1){
            //舍弃前半部分
            if(arr[mid] > arr[i] && arr[mid] > arr[j]){
                i = mid;
            }
            //舍弃后半部分
            else if(arr[mid] < arr[i] && arr[mid] < arr[j]){
                j = mid;
            }
            if(mid == (i+j)/2)
                break;
            mid = (i+j)/2;
        }
        if(arr[i] > arr[j])
            max = arr[i];
        else
            max = arr[j];
        return max;
    }
}

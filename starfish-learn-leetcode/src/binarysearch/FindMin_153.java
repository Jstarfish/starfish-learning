package binarysearch;

/**
 * @author Henry
 * @date 2022/3/14
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须设计一个时间复杂度为O(log n) 的算法解决此问题。
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 */
public class FindMin_153 {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[right]){
                right = mid;
            }else if(nums[mid] >= nums[right]){
                left = mid + 1;
            }

        }
        return nums[left];
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{5,6,7,1,2,3,4};
        int[] nums = new int[]{5,1,2,3,4};
        System.out.println(findMin(nums));

        //System.out.println(findMax(nums));
    }

    //找旋转数组中最大值
    public static int findMax(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) >> 1;

            //因为向下取整，left可能会等于mid，所以要考虑
            if (nums[left] < nums[right]) {
                return nums[right];
            }

            //[left,mid] 是递增的，最大值只会在[mid,right]中
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                //[mid,right]递增，最大值只会在[left, mid-1]中
                right = mid - 1;
            }
        }
        return nums[left];
    }
}

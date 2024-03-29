package binarysearch;

/**
 * @author Henry
 * @date 2022/3/14
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 */
public class Search_33 {

    public static int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return -1;
        }
        if(length ==1){
            return target == nums[0] ? 0 : -1;
        }

        int left = 0;
        int right = length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target == nums[mid]){
                return mid;
            }
            //左侧有序
            if(nums[0] < nums[mid]){
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }else{
                if (nums[mid] < target && target <= nums[right - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }

    public int search1(int[] nums,int target){
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[1] == target ? 0: -1;
        }
        int right = nums.length - 1;
        int left = 0;
        while(left < right){
            int mid = left + (right - left)/2;
            if(target == nums[mid]){
                return mid;
            }
            //6,8,1,2,4
            if(nums[0] < nums[mid]){
                if(nums[0] <= target && target <= nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if (nums[mid] < target && target <= nums[right - 1]) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }



        return -1;
    }

}



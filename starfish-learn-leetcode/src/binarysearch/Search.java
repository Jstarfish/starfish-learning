package binarysearch;

/**
 * @author Henry
 * @date 2022/3/14
 */
public class Search {

    public static int getResult1(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        //1,2,2,5,7
        while(left <= right){
            int middle = left + (right - left)/2;
            if(target == nums[middle]){
                left =  middle + 1;
            }else if(target < nums[middle]){
                right = middle - 1;
            }else if(target > nums[middle]){
                left = middle + 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 target 比所有数都大，返回 -1
        if (right < 0) return -1;
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? right : -1;
    }




    public static int getResult(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //左边界
    public static int getLeftNums(int[] nums,int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,4,4,5,7,8};
        System.out.println(getResult1(nums,4));
        System.out.println(getLeftNums(nums,6));
    }


}

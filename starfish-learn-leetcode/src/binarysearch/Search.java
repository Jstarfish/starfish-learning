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

    //1,2,2,2,5,6
    //左边界
    public static int getLeftNums(int[] nums,int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 target 比所有数都大，返回 -1
        if (left == nums.length) return -1;
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{1,4,4,4,5,7,8};
        int[] nums = new int[]{1,2,3,4,5,7,8};
        System.out.println(getResult1(nums,4));
        System.out.println(getLeftNums(nums,4));
        System.out.println(getRightNums(nums,4));
    }

    public static int getRightNums(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] == target) {
                // 收缩左侧边界
                left = mid + 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // if (left - 1 < 0) return -1;
        // return nums[left - 1] == target ? (left - 1) : -1;
        // 由于 while 的结束条件是 right == left - 1，且现在在求右边界
        // 所以用 right 替代 left - 1 更好记
        if (right < 0) return -1;
        return target == nums[right] ? nums[right] : -1;
    }


}

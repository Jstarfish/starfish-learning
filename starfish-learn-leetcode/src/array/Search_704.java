package array;

/**
 * @author Henry
 * @date 2021/11/25
 *
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class Search_704 {

    public int search(int[] nums,int target){

        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int middle = (right - left) / 2;
            if(target == middle){
                return middle;
            }else if(nums[middle] < target){
                right = middle - 1;
            }else if (nums[middle] > target){
                left = middle + 1;
            }

        }
        return -1;
    }
}

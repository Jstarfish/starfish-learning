package array.twopointer;

/**
 * 最简单的二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
 * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class BinarySearch {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //不直接使用（right+left）/2 是考虑数据大的时候溢出
            int mid = (right - left) / 2 + left;
            int tmp = nums[mid];
            if (tmp == target) {
                return mid;
            } else if (tmp > target) {
                //右指针移到中间位置 - 1,也避免不存在的target造成死循环
                right = mid - 1;
            } else {
                //
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,9,12};
        System.out.println(search(nums,4));
    }
}

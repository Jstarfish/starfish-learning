package binarysearch;

/**
 * @author Henry
 * @date 2022/3/15
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class FindPeakElement_162 {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        // 先特判两边情况
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            // 当前为峰值
            if (mid >= 1 && mid < n - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid >= 1 && nums[mid] < nums[mid - 1]) {
                // 峰值在 mid 左侧
                r = mid - 1;
            } else if (mid < n - 1 && nums[mid] < nums[mid + 1]) {
                // 峰值在 mid 右侧
                l = mid + 1;
            }
        }
        return -1;
    }
}

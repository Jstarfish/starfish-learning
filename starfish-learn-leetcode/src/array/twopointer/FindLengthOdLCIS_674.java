package array.twopointer;

/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 */
public class FindLengthOdLCIS_674 {

    public int findLengthOfLCIS(int[] nums) {
        int result = 0;
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            //前一个数大于后一个数的时候
            if (fast > 0 || nums[fast - 1] > nums[fast]) {
                slow = fast;
            }
            fast++;
            result = Math.max(result, fast - slow);
        }
        return result;
    }
}

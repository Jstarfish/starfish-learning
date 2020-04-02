package array;

/**
 * @description: 至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *
 *
 * 示例 2:
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *
 *
 * 提示:
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 100].
 **/


public class LargestNum {

    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        System.out.println(dominantIndex(nums));

    }

    /**
     * 方法：线性扫描
     *
     * 算法：
     * 扫描数组找到唯一的最大元素 m，并记录它的索引 maxIndex。
     * 再次扫描数组，如果我们找到 x != m，m < 2*x，我们应该返回 -1。
     * 否则返回 maxIndex
     *
     * 复杂度分析
     * 时间复杂度：O(N)O(N)。NN 指的是 nums 的大小
     * 空间复杂度：O(1)O(1)，只用了常数空间。
     **/
    public static int dominantIndex(int[] nums) {

        int maxIndex = 0;
        //找出最大值的索引
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i]) {
                return -1;
            }
        }
        return maxIndex;
    }
}

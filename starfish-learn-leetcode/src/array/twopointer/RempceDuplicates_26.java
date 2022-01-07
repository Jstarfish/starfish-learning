package array.twopointer;

/**
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 */
public class RempceDuplicates_26 {
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            //和前一个值比较
            if (nums[fast] != nums[fast - 1]) {
                //不一样的话，把快指针的值放在慢指针上，实现了去重，并往前移动慢指针
                nums[slow] = nums[fast];
                ++slow;
            }
            //相等的话，移动快指针就行
            ++fast;
        }
        //慢指针的位置就是不重复的数量
        return slow;
    }
}

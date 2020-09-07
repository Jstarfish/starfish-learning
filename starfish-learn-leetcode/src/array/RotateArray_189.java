package array;

/**
 * @description: 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class RotateArray_189 {


    /*
        最简单的方法是旋转 k 次，每次将数组旋转 1 个元素 ??
        如果没有空间复杂度为 O(1) 这个限制，这道题相对来说会简单很多，
        需要做的仅仅复制一份数组，然后将 [n - k, n] 区间上的元素覆盖在数组的开头，接着遍历并覆盖剩下的元素即可。
     */
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }


    /**
     * 使用额外的数组
     * 我们可以用一个额外的数组来将每个元素放到正确的位置上，
     * 也就是原本数组里下标为 i 的我们把它放到 (i+k)\%数组长度 的位置。然后把新的数组拷贝到原数组中
     *
     * @param nums
     * @param k
     */
    public void rotate_2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }


    /**
     * 三次反转
     * 这个方法基于这个事实：当我们旋转数组 k 次， k\%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k 个元素，就能得到想要的结果。
     * 假设 n=7 且 k=3 。
     *
     * @param nums
     * @param k
     */
    public void rotate_3(int[] nums,int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

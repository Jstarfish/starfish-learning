package tree.binarytree;

/**
 * @author Henry
 * @date 2022/2/15
 */
public class MaxBinaryTree_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return bulid(nums, 0, nums.length - 1);
    }

    private TreeNode bulid(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int index = -1;
        int maxVal = Integer.MIN_VALUE;

        //找出最大索引
        for (int i = lo; i < hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        //构建
        TreeNode root = new TreeNode(maxVal);
        //递归调用构造左右子树
        root.left = bulid(nums, lo, index - 1);
        root.right = bulid(nums, index + 1, hi);
        return root;
    }


}

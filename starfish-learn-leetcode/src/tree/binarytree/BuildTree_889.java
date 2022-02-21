package tree.binarytree;

/**
 * @author Henry
 * @date 2022/2/21
 * 根据前序和后序遍历构造二叉树
 */
public class BuildTree_889 {

    public TreeNode constructFromPrePost(int[] preorder,int[] postorder){
        return build(preorder,0,preorder.length-1,postorder,0,preorder.length-1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] postorder, int postStart, int postEnd) {
        if(preStart >preEnd){
            return null;
        }

        if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // root.left 的值是前序遍历第二个元素
        // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
        // 确定 preorder 和 postorder 中左右子树的元素区间
        int leftRootVal = preorder[preStart + 1];
        // leftRootVal 在后序遍历数组中的索引
        int index = 0;
        for (int i = postStart; i < postEnd; i++) {
            if (postorder[i] == leftRootVal) {
                index = i;
                break;
            }
        }
        // 左子树的元素个数
        int leftSize = index - postStart + 1;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);

        return root;

    }
}

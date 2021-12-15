package tree.binarytree;

/**
 * @author Henry
 * @date 2021/11/10
 */
public class MinDepth_111 {

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right == null){
            return 1;
        }

        int tmp = Integer.MAX_VALUE;
        if(root.left != null){
            tmp = Math.min(minDepth(root.left),tmp);
        }
        if(root.right != null){
            tmp = Math.min(minDepth(root.right),tmp);
        }

        return tmp + 1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        minDepth(root);
    }

}

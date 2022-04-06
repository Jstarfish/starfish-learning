package tree.binarytree;

/**
 * @author Henry
 * @date 2021/11/5
 * 反转二叉树
 *  输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 遍历，从叶子节点开始翻转
 */
public class InvertTree_226 {

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        /**** 前序遍历位置 ****/
        // root 节点需要交换它的左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 让左右子节点继续翻转它们的子节点
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode treeNode = invertTree(root);
        System.out.println(treeNode);

    }

    public static TreeNode invertTree5(TreeNode node){
        if(node == null){
            return null;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        invertTree5(node.left);
        invertTree5(node.right);
        return node;
    }

}

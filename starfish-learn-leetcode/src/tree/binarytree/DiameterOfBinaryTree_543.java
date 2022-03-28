package tree.binarytree;

/**
 * @author Henry
 * @date 2022/3/28
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class DiameterOfBinaryTree_543 {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root){
        depth(root);
        return res;
    }

    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        res = Math.max(left+right,res);
        //返回节点深度
        return Math.max(left,right)+1;
    }
}

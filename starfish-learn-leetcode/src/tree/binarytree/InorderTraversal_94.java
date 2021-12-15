package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Henry
 * @date 2021/11/4
 *
 *  给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class InorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    public void inorder(TreeNode treeNode,List<Integer> res){
        if(treeNode == null){
            return;
        }
        inorder(treeNode.left,res);
        res.add(treeNode.val);
        inorder(treeNode.right,res);
    }


    public static void main(String[] args) {
        InorderTraversal_94 traversal = new InorderTraversal_94();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        List<Integer> result = traversal.inorderTraversal(root);
        result.forEach(System.out::println);

    }




}

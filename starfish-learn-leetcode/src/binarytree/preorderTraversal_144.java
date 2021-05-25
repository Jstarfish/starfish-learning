package binarytree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 **/
class preorderTraversal_144 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,2,3);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }


    public void preorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }

}







package binarytree;

/**
 * @description:
 * @author: starfish
 * @date: 2021/5/19 20:36
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

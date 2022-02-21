package tree.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Henry
 * @date 2022/2/21
 * s利用后序和中序遍历的结果数组来还原二叉树
 */
public class BuildTree_106 {
    public TreeNode buildTree(int[] inorder,int[] postorder){
        int length = inorder.length;
        return build(inorder,0,length-1,postorder,0,length-1);
    }

    public TreeNode build(int[] inorder, int inleft, int inright, int[] postorder, int postleft, int postright) {

        //后续遍历的最后一个元素就是root节点
        TreeNode root = new TreeNode(postorder[postright]);
        //root节点在中序遍历中的位置
        int index = 0;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == postorder[postright]){
                index = i;
                break;
            }
        }
        int leftSize = index - inleft;

        root.left = build(inorder,inleft,index-1,postorder,postleft,postleft+leftSize-1);
        root.right = build(inorder,inleft+1,inright,postorder,postleft+leftSize,postright-1);
        return root;
    }

}

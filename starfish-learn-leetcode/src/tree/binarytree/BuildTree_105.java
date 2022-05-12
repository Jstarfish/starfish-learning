package tree.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Henry
 * @date 2021/11/24
 * 给定一棵树的前序遍历preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
 * 示例 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class BuildTree_105 {

    private Map<Integer,Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }

        int n = preorder.length;

        return build(preorder,0,n-1,inorder,0,n-1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if(preStart > preEnd){
            return null;
        }

        //找到root 索引
        int rootVal = preorder[preStart];
        int index = indexMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;

        root.left = build(preorder,preStart+1,preStart+leftSize,inorder,inStart,index-1);
        root.right = build(preorder,preStart+leftSize+1,preEnd-1,inorder,index+1,inEnd);
        return root;

    }


    public static void main(String[] args) {
        BuildTree_105 tree = new BuildTree_105();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = tree.buildTree(preorder, inorder);
        System.out.println(treeNode.toString());
    }


}

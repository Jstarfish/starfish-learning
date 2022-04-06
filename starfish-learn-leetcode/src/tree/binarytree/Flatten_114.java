package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Henry
 * @date 2022/4/6
 */
public class Flatten_114 {

    public void flatten(TreeNode node) {
        List<TreeNode> res = new ArrayList<>();
        preorder(node, res);
        int size = res.size();
        for (int i = 0; i < size; i++) {
            TreeNode pre = res.get(i);
            TreeNode curr = res.get(i + 1);
            pre.left = null;
            pre.right = curr;
        }
    }

    private void preorder(TreeNode node, List<TreeNode> res) {
        if (node == null) {
            return;
        }
        res.add(node);
        preorder(node.left, res);
        preorder(node.right, res);
    }

}

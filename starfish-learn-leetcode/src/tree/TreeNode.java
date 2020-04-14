package tree;

/**
 * @description:
 * @author: starfish
 * @create: 2020-04-14 15:34
 **/
public class TreeNode<E extends Comparable<E>>{


    private E data;
    private TreeNode<E> left;
    private TreeNode<E> right;
    TreeNode(E theData){
        data = theData;
        left = null;
        right = null;
    }


    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }
}

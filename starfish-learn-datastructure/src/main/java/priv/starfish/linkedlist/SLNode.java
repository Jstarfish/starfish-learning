package priv.starfish.linkedlist;

/**
 * @description:
 * @author: starfish
 * @data: 2020-07-27 21:43
 **/
public class SLNode implements Node {
    private Object element;
    private SLNode next;

    public SLNode() {
        this(null, null);
    }

    public SLNode(Object ele, SLNode next) {
        this.element = ele;
        this.next = next;
    }

    public SLNode getNext() {
        return next;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }

    /**************** Methods of Node Interface **************/
    public Object getData() {

        return element;
    }

    public void setData(Object obj) {
        element = obj;
    }
}


package priv.starfish.linkedlist;

import javax.swing.*;

/**
 * @description:
 * @author: starfish
 * @data: 2020-07-27 21:55
 **/
public class DLNode{
    private Object element;
    private DLNode pre;
    private DLNode next;

    public DLNode() {
        this(null, null, null);
    }

    public DLNode(Object ele, DLNode pre, DLNode next) {
        this.element = ele;
        this.pre = pre;
        this.next = next;
    }

    public DLNode getNext() {
        return next;
    }

    public void setNext(DLNode next) {
        this.next = next;
    }

    public DLNode getPre() {
        return pre;
    }

    public void setPre(DLNode pre) {
        this.pre = pre;
    }

    /****************Node Interface Method**************/
    public Object getData() {
        return element;
    }

    public void setData(Object obj) {
        element = obj;
    }
}



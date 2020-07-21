package priv.starfish.stack;

/**
 * @description:
 * @author: starfish
 * @create: 2020-07-20 19:47
 */
public class MyLinkedStack implements MyStack {

    class Node {
        private Object element;
        private Node next;

        public Node() {
            this(null, null);
        }

        public Node(Object ele, Node next) {
            this.element = ele;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getData() {
            return element;
        }

        public void setData(Object obj) {
            element = obj;
        }
    }

    private Node top;
    private int size;

    public MyLinkedStack() {
        top = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Object e) {
        Node node = new Node(e, top);
        top = node;
        size++;
    }

    public Object pop() {
        if (size < 1) {
            throw new RuntimeException("堆栈为空");
        }
        Object obj = top.getData();
        top = top.getNext();
        size--;
        return obj;
    }

    public Object peek() {
        if (size < 1) {
            throw new RuntimeException("堆栈为空");
        }
        return top.getData();
    }

    public static void main(String[] args) {
        MyLinkedStack linkedStack = new MyLinkedStack();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.pop();
        System.out.println(linkedStack.peek());
    }
}

package priv.starfish.queue;

/**
 * @description: 单链表队列
 * @author: starfish
 * @create: 2020-07-20 15:51
 **/
public class MyLinkedQueue implements MyQueue {

    /**
     * 链表结构，肯定要先有个Node,放结点信息
     */
    class Node {
        private Object element;
        private Node next;

        public Node() {
            this(null,null);
        }

        public Node(Object ele, Node next){
            this.element = ele;
            this.next = next;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }
        public Object getData() {
            return element;
        }

        public void setData(Object obj) {
            element = obj;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public MyLinkedQueue() {
        this.front = new Node();
        this.rear = front;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return false;
    }

    public void enqueue(Object e) {
        Node node = new Node(e, null);
        rear.setNext(node);
        rear = node;
        size++;
    }

    public Object dequeue() {
        if (size < 1) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        Node p = front.getNext();
        front.setNext(p.getNext());
        size--;
        if (size < 1) {
            rear = front;//如果队列为空，
        }
        return p.getData();
    }

    public Object peek() {
        Node node = front;
        if (size < 1) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return front.getNext().getData();
    }

    public static void main(String[] args) {
        MyLinkedQueue linkedQueue = new MyLinkedQueue();
        linkedQueue.enqueue(1);
        System.out.println(linkedQueue.peek());
        linkedQueue.enqueue(2);
        linkedQueue.dequeue();
        System.out.println(linkedQueue.peek());
    }
}

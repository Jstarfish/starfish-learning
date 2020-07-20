package priv.starfish.queue;

/**
 * @description:
 * @author: starfish
 * @create: 2020-07-20 14:57
 **/
public class MyArrayQueue implements MyQueue {

    private int capacity; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private Object[] arr; // 该数据用于存放数据, 模拟队列

    // 创建队列的构造器
    public MyArrayQueue(int capacity) {
        this.capacity = capacity;
        arr = new Object[capacity];
        front = -1; // 指向队列头部，分析出front是指向队列头的前一个位置.
        rear = -1; // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    }

    public int getSize() {
        return rear - front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public void enqueue(Object e) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++; // 让rear 后移
        arr[rear] = e;
    }

    public Object dequeue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++; // front后移
        return arr[front];
    }

    public Object peek() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }

    public static void main(String[] args) {
        MyArrayQueue queue = new MyArrayQueue(2);
        System.out.println(queue.getSize());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
    }
}

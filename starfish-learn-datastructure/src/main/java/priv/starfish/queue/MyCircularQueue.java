package priv.starfish.queue;

/**
 * @description:
 * @author: starfish
 * @data: 2020-07-19 17:37
 **/
class MyCircularQueue implements MyQueue{

    private Object[] data;
    private int capacity;
    private int front;
    private int rear;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity = k;
        data = new Object[k];
    }

    public int getSize() {
        return (rear - front + capacity) % capacity;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((rear + 1) % capacity) == front;
    }

    public void enqueue(Object e) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        //直接将数据加入
        data[rear] = e;
        //将 rear 后移, 这里必须考虑取模
        rear = (rear + 1) % capacity;
    }

    public Object dequeue() {
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        Object value = data[front];
        front = (front + 1) % capacity;
        return value;
    }


    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有可读数据");
        }
        Object obj = data[front];
        return obj;
    }


    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enqueue(1);
        myCircularQueue.enqueue(2);
        myCircularQueue.enqueue(3);
        myCircularQueue.enqueue(4);
        System.out.println(myCircularQueue.peek());


    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

package priv.starfish.queue;

public interface MyQueue {

    /**
     * 返回队列大小
     */
    public int getSize();

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty();

    /**
     * 判断队列是否已满
     */
    public boolean isFull();

    /**
     * 数据元素e进入队列
     */
    public void enqueue(Object e);

    /**
     * 队首出队元素
     */
    public Object dequeue();

    /**
     * 取队首元素
     */
    public Object peek();
}

package priv.starfish.queue;

/**
 * @description: 优先队列实现
 * @author: starfish
 * @create: 2020-07-20 17:36
 **/
public class MyPriorityQueue {

    private int maxSize;
    private long[] queArray;
    private int nItems;

    public MyPriorityQueue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }


    public int getSize() {
        return queArray.length;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public void enqueue(long e) {
        int j;
        if (nItems == 0) {
            queArray[nItems++] = e;
        } else {
            for (j = nItems - 1; j >= 0; j--) {
                if (e > queArray[j]) {
                    queArray[j + 1] = queArray[j];
                } else {
                    break;
                }
            }
            queArray[j + 1] = e;
            nItems++;
        }
    }

    public Object dequeue() {
        return queArray[--nItems];
    }

    public Object peek() {
        return queArray[nItems - 1];
    }

    public static void main(String[] args) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue(3);
        myPriorityQueue.enqueue(3);
        myPriorityQueue.enqueue(2);
        myPriorityQueue.enqueue(4);
        System.out.println(myPriorityQueue.dequeue());
    }
}

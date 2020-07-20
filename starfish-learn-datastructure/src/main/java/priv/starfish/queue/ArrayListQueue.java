package priv.starfish.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 数组模拟队列
 * @author: starfish
 * @data: 2020-07-19 17:02
 **/

public class ArrayListQueue {
    // store elements
    private List<Integer> data;
    // a pointer to indicate the start position
    private int p_start;

    public ArrayListQueue() {
        data = new ArrayList<Integer>();
        p_start = 0;
    }

    /**
     * Insert an element into the queue. Return true if the operation is successful.
     */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /**
     * Delete an element from the queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        p_start++;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return data.get(p_start);
    }

    /**
     * Checks whether the queue is empty or not.
     */
    public boolean isEmpty() {
        return p_start >= data.size();
    }

    public static void main(String[] args) {
        ArrayListQueue q = new ArrayListQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }

    }
}

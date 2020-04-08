package locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description: 可重入的自旋锁
 * @author: starfish
 * @create: 2020-04-08 17:50
 **/
public class ReentrantSpinLockDemo {


    private AtomicReference<Thread> lock = new AtomicReference<>();
    private int count;

    public void lock(){
        Thread current = Thread.currentThread();
        if(current == lock.get()){
            count ++;  // 如果当前线程已经获取到了锁，线程数增加一，然后返回
            return;
        }

        //没有获取锁，自旋
        while (!lock.compareAndSet(null,current)){

        }
    }

    public void unlock(){
        Thread current = Thread.currentThread();
        if(current == lock.get()){
            if(count > 0){
                count --;
            }else{
                lock.compareAndSet(current,null);
            }
        }
    }

}

package priv.starfish;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. 验证 volatile 可见性
 *      1.1 假如 int number =0；number变量前没有volatile关键字修饰,没有可见性
 *      1.2 添加了volatile,解决了可见性问题
 * 2. 验证 volatile  不保证原子性
 *      2.1 原子性指的是什么？
 *          不可分割，完整性，某个线程在做某个具体业务时，中间不可以被加塞或分割，要么整体成功，要么失败
 *      2.2  通过20个线程对number++，证实volatile不保证原子性，
 *             数据不是2000，因为多线程竞争关系，出现了丢失写值的情况
 *
 *  3. 如何解决原子性？
 *      加 synchronized
 *      直接使用 Automic 原子类
 *
 **/
public class VolatileDemo {

    public static void main(String[] args) throws InterruptedException {

        //seeOkByVolatile();

        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() ->{
                for (int j = 0; j < 1000; j++) {
                    //myData.addPlusPlus();

                    myData.atomicAdd();
                }
            },"addPlusThread:"+ i).start();
        }


        //等待上边20个线程结束后(预计5秒肯定结束了)，在main线程中获取最后的number
 //       TimeUnit.SECONDS.sleep(5);
//        while (Thread.activeCount() > 2){
//            Thread.yield();
//        }

        //正常情况，输出值应该是20000，运行后会发现不一定是
        System.out.println(Thread.currentThread().getName()+",int :"+myData.number);
        System.out.println(Thread.currentThread().getName()+",atomicInterger:"+myData.atomicNum);


    }


    //写好代码后，选中要提取的代码，右键Refactor,选择Extract
    //voaltile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
    private static void seeOkByVolatile() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");

            try {
                //Thread.sleep(200);
                TimeUnit.SECONDS.sleep(2);
                myData.addTo18();

                System.out.println(Thread.currentThread().getName()+"\t update number value :"+myData.number);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "AAA").start();

        //第2个线程，main线程
        while (myData.number == 0){
            //main线程还在找0
        }

        System.out.println(Thread.currentThread().getName()+"\t mission is over");

        //不加volatile,不会执行下边输出语句，在number前加关键字 volatile,重新运行

        System.out.println(Thread.currentThread().getName()+"\t mission is over，main get number is:"+myData.number);
    }
}


class MyData {
    volatile int number = 0;

    public void addTo18() {
        this.number = 18;
    }

    public void addPlusPlus(){
        number ++;
    }

    //原子性
    AtomicInteger atomicNum = new AtomicInteger();

    public void atomicAdd(){
        atomicNum.getAndIncrement();   //原子性的
    }
}
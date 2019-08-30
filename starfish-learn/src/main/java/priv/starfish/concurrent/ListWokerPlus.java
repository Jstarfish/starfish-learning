package priv.starfish.concurrent;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: jiahaixin
 * @date: 2019/8/6 10:33
 * @description:
 */
public class ListWokerPlus extends Thread{

    private List<String> workList;
    private AtomicInteger index;
    private int executenum=0;//本线程处理任务量
    private int  localIndex;
    public ListWokerPlus(List<String>  worklIist,AtomicInteger  index){
        this.workList=worklIist;
        this.index=index;
    }
    @Override
    public void run() {
        /*抢占式*/
        while(true){
            synchronized (workList) {
                localIndex=index.intValue();
                index.incrementAndGet();
            }
            if(localIndex>=workList.size()){
                System.out.println("----任务处理完成----线程"+Thread.currentThread().getName()+"---结束运行------本次处理任务量:"+executenum);
                break;
            }
            else{
                String msg=workList.get(localIndex);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("线程"+Thread.currentThread().getName()+"处理完任务"+localIndex+",返回结果:"+msg);
                    executenum++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

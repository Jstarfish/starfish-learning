package priv.starfish;

/**
 * @description: volatile 关键字
 * @author: starfish
 * @data: 2020-03-11 20:57
 **/
public class VolatileTest {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();


        while(true){
        //synchronized (td){
            if(td.isFlag()){
                System.out.println("------------------");
                break;
        //    }
        }

        }

    }

}

class ThreadDemo implements Runnable {

    private volatile boolean flag = false;

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        flag = true;

        System.out.println("flag=" + isFlag());

    }

    public boolean isFlag() {
        return flag;
    }
}
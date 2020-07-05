package oom;

/**
 * @description:
 * @author: starfish
 * @data: 2020-07-05 17:16
 **/
public class UnableCreateNewThreadDemo {

    public static void main(String[] args) {

//        for (int i = 0; ; i++) {
//            System.out.println(i);
//            new Thread(() -> {
//                try {
//                    Thread.sleep(Integer.MAX_VALUE);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }, String.valueOf(i)).start();
//        }

        while(true){
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch(InterruptedException e) { }
            }).start();
        }
    }
}

package single;

/**
 * 懒汉式： 同步方法
 *
 *  解决了线程不安全问题，但是效率太低了，每个线程想获得类的实例的时候，都需要同步方法，不推荐
 */

public class Singleton1 {

//    private static Singleton1 singleton;
//
//    private Singleton1(){}
//
//    public static synchronized Singleton1 getInstance(){
//        if(singleton == null){
//            singleton = new Singleton1();
//        }
//        return singleton;
//    }


    private static Singleton1 singleton;

    private Singleton1(){}

    public static Singleton1 getInstance(){
        if(singleton == null){

            synchronized (Singleton1.class){

                singleton = new Singleton1();
            }
        }
        return singleton;
    }




}

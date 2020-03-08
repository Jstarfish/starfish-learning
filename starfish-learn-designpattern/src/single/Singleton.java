package single;


/**
 * 懒汉式单例模式  双重检查 线程安全
 */
public class Singleton {



//    private static volatile Singleton singleton;
//
//    private Singleton(){}
//
//
//    public static Singleton getInstance(){
//        if(singleton ==null){
//            synchronized (Singleton.class){
//                if(singleton == null){
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }



    private Singleton(){}

    private static class SingletonInstance{

        private static final Singleton INSTANCE = new Singleton();

    }


    public static Singleton getInstance(){

        return SingletonInstance.INSTANCE;
    }




}

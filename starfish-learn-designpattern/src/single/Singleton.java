package single;


/**
 * 懒汉式单例模式  双重检查 线程安全
 */
public class Singleton {


    private Singleton(){

    }

    private static Singleton instance;

    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }






}

package priv.starfish;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-22 15:19
 **/
public class Singleton {

    private static volatile Singleton instance;

    private Singleton(){}
    // DCL
    public static Singleton getInstance(){
        if(instance ==null){   //第一次检查
            synchronized (Singleton.class){
                if(instance == null){   //第二次检查
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}

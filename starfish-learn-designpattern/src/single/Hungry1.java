package single;

public class  Hungry1 {


    //构造私有化，防止直接new
    private Hungry1(){

    }

    private static Hungry1 instance = new Hungry1();


    //也可以将实例化对象放在静态代码块里
//    static {
//        instance = new Hungry1();
//    }

    public static Hungry1 getInstance(){
        return instance;
    }


    public static void main(String[] args) {

        Hungry1 hungry1 = Hungry1.getInstance();
        Hungry1 hungry11 = Hungry1.getInstance();

        System.out.println(hungry1 == hungry11);

        System.out.println(hungry1.hashCode());
        System.out.println(hungry11.hashCode());

    }
}

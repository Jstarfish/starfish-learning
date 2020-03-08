package priv.starfish.jvm;

/**
 * @description: 局部变量表
 * @author: starfish
 * @data: 2020-02-26 14:09
 **/
public class LocalVairableTest {

    int i;

    public void test(){
        int a = 1;
        int ii;

        System.out.println(i);
       //  System.out.println(ii); //

        {
            int b = 2;
            b = a + 1;
        }

        int c = a + 1;
    }

    public static void main(String[] args) {
        LocalVairableTest localVairableTest = new LocalVairableTest();
        localVairableTest.test();
    }
}

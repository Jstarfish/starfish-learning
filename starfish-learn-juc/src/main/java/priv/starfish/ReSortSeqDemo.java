package priv.starfish;

/**
 * @description: 指令重排
 * @author: starfish
 * @data: 2020-03-22 11:26
 **/
public class ReSortSeqDemo {

    int a = 0;
    boolean flag = false;

    public void mehtod1(){
        a = 1;
        flag = true;
    }

    public void method2(){
        if(flag){
            a = a +1;
            System.out.println("reorder value: "+a);
        }
    }
}

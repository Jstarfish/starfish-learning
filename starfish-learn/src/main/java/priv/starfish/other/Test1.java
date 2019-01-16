package priv.starfish.other;

/**
 * @author: jiahaixin
 * @date: 2018/11/12 10:50
 * @description:
 */
public class Test1 {


    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) {

        System.out.println(COUNT_BITS);
        System.out.println(RUNNING);
    }
}

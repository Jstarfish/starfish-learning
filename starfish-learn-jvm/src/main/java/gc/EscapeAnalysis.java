package gc;

/**
 * @description: 逃逸分析
 *
 *  如何快速的判断是否发生了逃逸分析，就看new的对象是否有可能在方法外被调用
 * @author: starfish
 * @data: 2020-06-16 11:36
 **/
public class EscapeAnalysis {

    public EscapeAnalysis obj;


    /*
     * 方法返回对象，发生逃逸
     */
    public EscapeAnalysis getInstance(){
        return obj == null? new EscapeAnalysis():obj;
    }


    /*
      为成员属性赋值，发生逃逸
     */
    public void setObj(){
        this.obj = new EscapeAnalysis();
    }


    /*
        对象的作用域仅在当前方法有效，没有发生逃逸
     */
    public void useEscape(){
        EscapeAnalysis analysis = new EscapeAnalysis();
    }


    /*
        引用成员变量的值，发生逃逸
     */
    public void useAnalysis(){
        EscapeAnalysis e = getInstance();
    }

}

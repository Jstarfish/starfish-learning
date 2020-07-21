package priv.starfish.stack;

public interface MyStack {

    /**
     * 返回堆栈的大小
     */
    public int getSize();

    /**
     * 判断堆栈是否为空
     */
    public boolean isEmpty();

    /**
     * 入栈
     */
    public void push(Object e);

    /**
     * 出栈，并删除
     */
    public Object pop();

    /**
     * 返回栈顶元素
     */
    public Object peek();
}

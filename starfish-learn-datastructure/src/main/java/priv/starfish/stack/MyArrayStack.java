package priv.starfish.stack;

import priv.starfish.queue.MyArrayQueue;

/**
 * @description: 数组实现栈
 * @author: starfish
 * @create: 2020-07-20 19:02
 */
public class MyArrayStack implements MyStack {

    private final int capacity = 2;  //默认容量
    private Object[] arrs;   //数据元素数组
    private int top;   //栈顶指针

    MyArrayStack(){
        top = -1;
        arrs = new Object[capacity];
    }

    public int getSize() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(Object e) {
        if(getSize() >= arrs.length){
           expandSapce();  //扩容
        }
        arrs[++top]=e;
    }

    private void expandSapce() {
        Object[] a = new Object[arrs.length * 2];
        for (int i = 0; i < arrs.length; i++) {
            a[i] = arrs[i];
        }
        arrs = a;
    }

    public Object pop() {
        if(getSize()<1){
            throw new RuntimeException("栈为空");
        }
        Object obj = arrs[top];
        arrs[top--] = null;
        return obj;
    }

    public Object peek() {
        if(getSize()<1){
            throw new RuntimeException("栈为空");
        }
        return arrs[top];
    }

    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

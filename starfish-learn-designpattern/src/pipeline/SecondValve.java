package pipeline;

/**
 * @description: 第二个阀门
 * @author: starfish
 * @date: 2021/5/25 17:11
 */
public class SecondValve implements Value {

    public Value next;

    @Override
    public Value getNext() {
        return next;
    }

    @Override
    public void setNext(Value v) {
        this.next = v;
    }

    @Override
    public FlowResult invoke(PipeLineContext context) {
        return  getNext().invoke(context);
    }
}

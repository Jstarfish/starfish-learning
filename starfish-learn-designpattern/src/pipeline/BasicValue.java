package pipeline;

/**
 * @description: 基础阀门
 * @author: starfish
 * @date: 2021/5/25 17:10
 */
public class BasicValue implements Value {

    protected Value next;

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
        return new FlowResult();
    }

}

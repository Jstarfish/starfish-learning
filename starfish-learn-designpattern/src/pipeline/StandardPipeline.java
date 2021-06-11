package pipeline;

/**
 * @description: 流水线实现
 * @author: starfish
 * @date: 2021/5/25 17:17
 */
public class StandardPipeline implements PipeLine {

    /**
     * 第一个阀门
     */
    private Value head;

    private Value next;

    @Override
    public Value getFirst() {
        return head;
    }

    @Override
    public Value getNext() {
        return next;
    }

    @Override
    public void setNext(Value v) {
        this.next = v;
    }

    @Override
    public void addValue(Value v) {
        if(head == null){
            head = v;
            v.setNext(next);
        }else{
            Value current = head;
            while (current != null){
                if(current.getNext() == next){
                    current.setNext(v);
                    v.setNext(next);
                    break;
                }
                current = current.getNext();
            }
        }

    }

    @Override
    public FlowResult start(PipeLineContext context) {
        if (context == null) {
            return FlowResult.fail("pipeLineContext should be not null!");
        }
        if (head == null) {
            return FlowResult.fail("there's no valve in current pipeLine!");
        }
        return head.invoke(context);
    }
}

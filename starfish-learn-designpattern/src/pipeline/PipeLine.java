package pipeline;

/**
 * @description: 管道接口
 * @author: starfish
 * @date: 2021/5/25 17:05
 */
public interface PipeLine {

    /**
     * 看业务情况，是否需要获取阀门信息
     * @return
     */
    Value getFirst();
    Value getNext();
    void setNext(Value v);
    void addValue(Value v);

    FlowResult start(PipeLineContext context);
}

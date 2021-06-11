package pipeline;

/**
 * @description: 阀门接口
 * @author: starfish
 * @date: 2021/5/25 17:04
 */
public interface Value {

    /**
     * 获取下一个阀门
     * @return Value 阀门
     */
    Value getNext();

    /**
     * 设置下一个阀门
     * @param v
     */
    void setNext(Value v);

    /**
     * 执行关傲
     * @param s
     */
    FlowResult invoke(PipeLineContext context);



}

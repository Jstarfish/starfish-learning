package pipeline;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 管道上下文：
 * PipeLineContext 实现管道上下文的概念，内部记录一个所处阀门在管道中的索引；使用HashMap存储业务数据，用户流程进行时的数据传递。
 * @author: starfish
 * @date: 2021/5/25 17:58
 */
public class PipeLineContext {

    private Integer index;
    private Map<String,Object> context;

    public PipeLineContext(Integer size){
        this.index = 0;
        this.context = new HashMap<>(size);
    }

    public void put(String key,Object value){
        context.put(key,value);
    }

    public void get(String key){
        context.get(key);
    }

    public int getAndIncreament(){
        this.index++;
        return index;
    }

    @Override
    public String toString() {
        return "{\"index\":\"" + index + "\", \"context\":\"" + context.toString() + "\"}";
    }
}

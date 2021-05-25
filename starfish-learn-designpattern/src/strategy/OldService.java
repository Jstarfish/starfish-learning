package strategy;

/**
 * @description: 传统的多重if-else
 * @author: starfish
 * @date: 2021/4/16 11:30
 */
public class OldService {

    /**
     * 传统的 if else 解决方法
     * 当每个业务逻辑有 3 4 行时，用传统的策略模式不值得，直接的if else又显得不易读
     */
    public String getCheckResult(String type) {
        if ("校验1".equals(type)) {
            return "执行业务逻辑1";
        } else if ("校验2".equals(type)) {
            return "执行业务逻辑2";
        } else if ("校验3".equals(type)) {
            return "执行业务逻辑3";
        } else if ("校验4".equals(type)) {
            return "执行业务逻辑4";
        } else if ("校验5".equals(type)) {
            return "执行业务逻辑5";
        } else if ("校验6".equals(type)) {
            return "执行业务逻辑6";
        } else if ("校验7".equals(type)) {
            return "执行业务逻辑7";
        } else if ("校验8".equals(type)) {
            return "执行业务逻辑8";
        } else if ("校验9".equals(type)) {
            return "执行业务逻辑9";
        }
        return "不在处理的逻辑中返回业务错误";
    }
}

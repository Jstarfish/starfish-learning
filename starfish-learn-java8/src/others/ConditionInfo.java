package others;

import java.io.Serializable;

/**
 * @description:
 * @author: starfish
 * @date: 2021/4/7 20:05
 */
public class ConditionInfo implements Serializable {

    private static final long serialVersionUID = 6397318259849502123L;
    private String field;
    private String condition;
    private String value;

    public ConditionInfo() {
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return "ConditionInfo [field=" + this.field + ", condition=" + this.condition + ", value=" + this.value + "]";
    }
}

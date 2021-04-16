package others;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: starfish
 * @date: 2021/4/7 20:02
 */
public class ConditionInfoDto {

    private static final long serialVersionUID = 3752731397815465763L;
    private String field;
    private Operators operate;
    private String value;
    private List<String> multiValue;
    private RangeCondition rangeCondition;
    private List<ConditionInfoDto> subOrConditions;

    public ConditionInfoDto() {
    }

    public static ConditionInfoDto.Builder builder() {
        return new ConditionInfoDto.Builder();
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setOperate(Operators operate) {
        this.operate = operate;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setMultiValue(List<String> multiValue) {
        this.multiValue = multiValue;
    }

    public void setRangeCondition(RangeCondition rangeCondition) {
        this.rangeCondition = rangeCondition;
    }

    public void setSubOrConditions(List<ConditionInfoDto> subOrConditions) {
        this.subOrConditions = subOrConditions;
    }

    public String getField() {
        return this.field;
    }

    public Operators getOperate() {
        return this.operate;
    }

    public String getValue() {
        return this.value;
    }

    public List<String> getMultiValue() {
        return this.multiValue;
    }

    public RangeCondition getRangeCondition() {
        return this.rangeCondition;
    }

    public List<ConditionInfoDto> getSubOrConditions() {
        return this.subOrConditions;
    }

    public String toString() {
        return "ConditionInfoDto(field=" + this.getField() + ", operate=" + this.getOperate() + ", value=" + this.getValue() + ", multiValue=" + this.getMultiValue() + ", rangeCondition=" + this.getRangeCondition() + ", subOrConditions=" + this.getSubOrConditions() + ")";
    }

    public static final class Builder {
        private List<ConditionInfoDto> subConditionList = new ArrayList();

        public Builder() {
        }

        public ConditionInfoDto.Builder addORSubCondition(ConditionInfoDto conditionInfoDto) {
            if (conditionInfoDto == null) {
                throw new IllegalArgumentException("subCondition can not be empty.");
            } else {
                this.subConditionList.add(conditionInfoDto);
                return this;
            }
        }

        public List<ConditionInfoDto> toCondiionList(ConditionInfoDto conditionInfoDto) {
            return this.subConditionList;
        }

        public ConditionInfoDto buildSubCondition(Operators operators) {
            ConditionInfoDto conditionInfoDto = new ConditionInfoDto();
            conditionInfoDto.setOperate(operators);
            conditionInfoDto.setSubOrConditions(this.subConditionList);
            return conditionInfoDto;
        }
    }
}

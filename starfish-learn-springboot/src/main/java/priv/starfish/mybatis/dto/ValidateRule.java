package priv.starfish.mybatis.dto;

import java.io.Serializable;

/**
 * @description:
 * @author: starfish
 * @date: 2021/2/9 10:54
 */
public class ValidateRule implements Serializable {
    private static final long serialVersionUID = 620063345612622827L;
    private String min;
    private String max;
    private String pattern;
    private String regex;
    private String include;
    private String exclude;
    private Boolean nonnegative;

    public ValidateRule() {
    }

    public String getMin() {
        return this.min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return this.max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getInclude() {
        return this.include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    public String getExclude() {
        return this.exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public Boolean getNonnegative() {
        return this.nonnegative;
    }

    public void setNonnegative(Boolean nonnegative) {
        this.nonnegative = nonnegative;
    }

    public String toString() {
        return "ValidateRule{min='" + this.min + '\'' + ", max='" + this.max + '\'' + ", pattern='" + this.pattern + '\'' + ", regex='" + this.regex + '\'' + ", include='" + this.include + '\'' + ", exclude='" + this.exclude + '\'' + ", nonnegative=" + this.nonnegative + '}';
    }
}

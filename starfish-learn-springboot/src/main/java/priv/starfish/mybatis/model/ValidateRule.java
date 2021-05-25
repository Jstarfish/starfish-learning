package priv.starfish.mybatis.model;

import java.io.Serializable;

public class ValidateRule implements Serializable{
	
	private static final long serialVersionUID = 620063345612622827L;
	
	// 数字型代表最小值，字符串型代表最小长度
	private String min;
	// 数字型代表最大值，字符串型代表最大长度
	private String max;
	// 规则匹配
	private String pattern;
	// 正则校验
	private String regex;
	// 需要包含某些字段
	private String include;
	// 不能包含某些字段
	private String exclude;
	// 是否非负
	private Boolean nonnegative;
	
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
	}
	public String getInclude() {
		return include;
	}
	public void setInclude(String include) {
		this.include = include;
	}
	public String getExclude() {
		return exclude;
	}
	public void setExclude(String exclude) {
		this.exclude = exclude;
	}

	public Boolean getNonnegative() {
		return nonnegative;
	}

	public void setNonnegative(Boolean nonnegative) {
		this.nonnegative = nonnegative;
	}

	@Override
	public String toString() {
		return "ValidateRule{" +
				"min='" + min + '\'' +
				", max='" + max + '\'' +
				", pattern='" + pattern + '\'' +
				", regex='" + regex + '\'' +
				", include='" + include + '\'' +
				", exclude='" + exclude + '\'' +
				", nonnegative=" + nonnegative +
				'}';
	}
}

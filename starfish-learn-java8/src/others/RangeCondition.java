package others;

import java.io.Serializable;

/**
 * @description:
 * @author: starfish
 * @date: 2021/4/7 20:03
 */
public class RangeCondition implements Serializable {

    private static final long serialVersionUID = 3504621057571081671L;
    private String min;
    private String max;
    private boolean minInclusive = true;
    private boolean maxInclusive = true;

    public RangeCondition() {
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

    public boolean isMinInclusive() {
        return this.minInclusive;
    }

    public void setMinInclusive(boolean minInclusive) {
        this.minInclusive = minInclusive;
    }

    public boolean isMaxInclusive() {
        return this.maxInclusive;
    }

    public void setMaxInclusive(boolean maxInclusive) {
        this.maxInclusive = maxInclusive;
    }

    @Override
    public String toString() {
        return "RangeCondition{, min='" + this.min + '\'' + ", max='" + this.max + '\'' + ", minInclusive=" + this.minInclusive + ", maxInclusive=" + this.maxInclusive + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            RangeCondition that = (RangeCondition)o;
            if (this.minInclusive != that.minInclusive) {
                return false;
            } else if (this.maxInclusive != that.maxInclusive) {
                return false;
            } else {
                if (this.min != null) {
                    if (this.min.equals(that.min)) {
                        return this.max != null ? this.max.equals(that.max) : that.max == null;
                    }
                } else if (that.min == null) {
                    return this.max != null ? this.max.equals(that.max) : that.max == null;
                }

                return false;
            }
        } else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        int result = this.min != null ? this.min.hashCode() : 0;
        result = 31 * result + (this.max != null ? this.max.hashCode() : 0);
        result = 31 * result + (this.minInclusive ? 1 : 0);
        result = 31 * result + (this.maxInclusive ? 1 : 0);
        return result;
    }
}

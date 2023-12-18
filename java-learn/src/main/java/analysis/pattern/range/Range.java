package analysis.pattern.range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fuhailong
 * @Description 范围类
 * @Date 2023/12/12 20:08
 **/

@Data
@NoArgsConstructor
public class Range<T extends Comparable<T>> {

    private T upper;

    private T lower;

    public Range(T upper, T lower) {
        if (upper.compareTo(lower) < 0) {
         throw new IllegalArgumentException("下界不可以比上界大");
        }
        this.upper = upper;
        this.lower = lower;
    }

    public boolean isUpperInclusive(T value) {
        return value.compareTo(upper) <= 0;
    }

    public boolean isLowerInclusive(T value) {
        return value.compareTo(lower) >= 0;
    }

    /**
     * 是否包含某个值
     *
     * @param value
     * @return
     */
    public boolean includes(T value) {
        return (isLowerInclusive(value) && isUpperInclusive(value));
    }

    /**
     * 是否存在重叠
     *
     * @param otherRange
     * @return
     */
    public boolean overlaps(Range<T> otherRange) {
        return (isLowerInclusive(otherRange.upper) || isUpperInclusive(otherRange.lower));
    }

    /**
     * 是否相连
     *
     * @param otherRange
     * @return
     */
    public boolean abuts(Range<T> otherRange) {
        return (isLowerInclusive(otherRange.upper) && otherRange.lower.compareTo(upper) == 0) ||
                (isUpperInclusive(otherRange.lower) && otherRange.upper.compareTo(lower) == 0);
    }


}

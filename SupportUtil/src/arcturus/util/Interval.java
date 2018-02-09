package arcturus.util;

/**
 * 一个描述了区间的类
 */
public class Interval implements Cloneable {
    public static final String SEPARATOR = ", ";
    public int start;
    public int end;

    /**
     * 构造器
     * @param start 区间起点
     * @param end 区间终点
     */
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + SEPARATOR + end + ']';
    }

    /**
     * 利用默认的分隔符将给定的字符串转化为{@code Interval}实例
     * @param data 字符串数据
     * @return 转化的区间实例
     * @throws FormatException 转化出错时抛出异常
     */
    public static Interval parse(String data) throws FormatException {
        return parse(data, SEPARATOR);
    }

    /**
     * 利用给定的分隔符将给定的字符串转化为{@code Interval}实例
     * @param data 字符串数据
     * @param separator 分隔符
     * @return 转化的区间实例
     * @throws FormatException 转化出错时抛出异常
     */
    public static Interval parse(String data, String separator) throws FormatException {
        String[] nums = data.replace("[", "").replace("]", "").split(separator);
        if (nums.length != 2) throw new FormatException("An interval should have two components.");
        try {
            return new Interval(Integer.valueOf(nums[0].trim()), Integer.valueOf(nums[1].trim()));
        } catch (Exception e) {
            throw new FormatException(e);
        }
    }

    @Override
    public Interval clone() {
        return new Interval(this.start, this.end);
    }
}

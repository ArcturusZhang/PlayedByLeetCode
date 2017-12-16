package arcturus.util;

public class Interval {
    public static final String SEPARATOR = ", ";
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + SEPARATOR + end + ']';
    }

    public static Interval parse(String data) {
        return parse(data, SEPARATOR);
    }

    public static Interval parse(String data, String separator) {
        String[] nums = data.replace("[", "").replace("]", "").split(separator);
        if (nums.length != 2) throw new FormatException();
        return new Interval(Integer.valueOf(nums[0].trim()), Integer.valueOf(nums[1].trim()));
    }
}

package arcturus.util;

public class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + ']';
    }

    public static Interval parse(String string) {
        String[] nums = string.replace("[", "").replace("]", "").split(",");
        if (nums.length != 2) throw new FormatException();
        return new Interval(Integer.valueOf(nums[0].trim()), Integer.valueOf(nums[1].trim()));
    }
}

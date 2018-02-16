import java.util.HashMap;
import java.util.Map;

public class Solution2 extends Solution {
    /**
     * 多次调用优化：
     * 为调用过程增加一个缓存。将整数分为若干个Byte，将每个Byte的翻转结果存入一个HashMap中作为缓存。最后再将每个Byte翻转的结果连接为一个整数
     * @param n
     * @return
     */
    @Override
    public int reverseBits(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte)((n >>> (8 * i)) & 0xFF);
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]);
            if (i < 3) result <<= 8;
        }
        return result;
    }

    private final Map<Byte, Integer> cache = new HashMap<>();

    private int reverseByte(byte b) {
        if (cache.containsKey(b)) {
            return cache.get(b);
        } else {
            int result = 0;
            for (int i = 0; i < 8; i++) {
                result += (b >>> i) & 1;
                if (i < 7) result <<= 1;
            }
            cache.put(b, result);
            return result;
        }
    }
}

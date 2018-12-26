package bit;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/reverse-bits/description/
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Example:
 *
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
 *              return 964176192 represented in binary as 00111001011110000010100101000000.
 * @Author gcc
 * @Date 18-11-22 上午9:31
 **/
public class 将无符号32位数逆转 {
    /**
     * 一位一位地赋值
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            //n被当做无符号整数,使用无符号右移
            n = n >>> 1;
            if (i < 31) {
                //这里的左移是为下一个低位赋值做准备,如果i=32了,就不需要再右y移了
                result = result << 1;
            }
        }
        return result;
    }

    Map<Byte, Integer> cache = new HashMap<>();
    public int reverseBits2(int n) {
        byte[] bytes = new byte[4];
        //将n的32为分成4个字节放到bytes数组中
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte)((n >>> i*8) & 0xFF);
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += convertToInt(bytes[i]);
            if (i < 3) {
                result <<= 8;
            }
        }
        return result;
    }

    private int convertToInt(byte b) {
        if (cache.containsKey(b)) {
            return cache.get(b);
        }
        int res = 0;
        for (int i = 0; i < 8; i++) {
            res += (b >>> i & 1 );
            if (i < 7) {
                res <<= 1;
            }
        }
        cache.put(b, res);
        return res;
    }

    public static void main(String[] args) {
        int a = 2;
        System.out.println();
    }
}

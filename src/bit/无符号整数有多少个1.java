package bit;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/number-of-1-bits/description/
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * Example 1:
 * <p>
 * Input: 11
 * Output: 3
 * Explanation: Integer 11 has binary representation 00000000000000000000000000001011
 * @Author gcc
 * @Date 18-11-22 上午10:22
 **/
public class 无符号整数有多少个1 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    Map<Byte, Integer> cache = new HashMap<>();

    public int hammingWeight2(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte) (n & 0xFF);
            n >>>= 8;
        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            count += convertToNum(bytes[i]);
        }
        return count;
    }

    private int convertToNum(byte b) {
        if (cache.containsKey(b)) {
            return cache.get(b);
        }
        int count = 0;
        for (int i = 0; i < 8; i++) {
            //不要这样写,b被改变了,存到map中的b是一个被改变的值
/*            count += ((b & 1) == 1) ? 1:0;
            b >>>= 1;*/
            count += (((b >>> i) & 1) == 1) ? 1 : 0;
        }
        cache.put(b, count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new 无符号整数有多少个1().hammingWeight2(11));
    }
}

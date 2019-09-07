package bit;

/**
 * @Desc https://leetcode.com/problems/hamming-distance/
 * @Author gcc
 * @Date 19-6-9 下午8:28
 **/
public class 汉明距离 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i=0;i<32;i++) count += (xor >> i) & 1;
        return count;
    }
}

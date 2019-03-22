package array;

/**
 * @Desc https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @Author gcc
 * n个小朋友围城一圈，指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要圈。如此循环下去，问最后剩哪一个
 * @Date 19-3-21 上午9:25
 **/
public class 圆圈中最后剩下的数 {
    /**
     * @param n
     * @param m
     * @return
     */
    public int lastRemain(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        boolean[] removed = new boolean[n];
        // i为圆环中的索引，step 1-m=
        int step = 0, i=-1, remain = n;
        while (remain > 0) {
            i++;
            if (i == n) {
                i = 0;
            }
            if (removed[i]) {
                continue;
            }
            // 只要在遇到没有删除的step才会++
            // 而i则不必要，i用来模拟循环圆
            step++;
            if (step == m) {
                removed[i] = true;
                step = 0;
                remain--;
            }
        }
        return i;
    }
}

package binarySearch;

/**
 * @Desc https://leetcode.com/problems/sqrtx/description/
 * @Author gcc
 * @Date 18-10-24 下午9:30
 **/
public class 平方根函数 {
    /**
     * 返回值是int类型，比如8的平方根是2点几，返回2。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 0, end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end)/2;
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                //mid <= x / mid;
                start = mid + 1;
            }
        }
        return start - 1;
    }

    public static void main(String[] args) {
        System.out.println(new 平方根函数().mySqrt(0));
    }
}

package Math;

/**
 * @Desc https://leetcode.com/problems/happy-number/description/
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * @Author gcc
 * @Date 18-11-22 下午3:20
 **/
public class 快乐数字 {
    /**
     * 就是成环的地方,判断是否为1
     * 也可以用set保存经过过的值
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = next(slow);
            fast = next(fast);
            fast = next(fast);
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int next(int n) {
        int sum = 0;
        while (n > 0) {
            int remain = n % 10;
            sum += remain * remain;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new 快乐数字().next(68));
    }
}

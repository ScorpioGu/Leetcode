package math;

/**
 * @Desc https://leetcode.com/problems/integer-break/
 * @Author gcc
 * @Date 19-1-6 下午2:07
 **/
public class 将一个整数分割成很多部分求乘积最大 {
    /**
     * 解释在此处 : https://leetcode.com/problems/integer-break/discuss/80721/Why-factor-2-or-3-The-math-behind-this-problem.
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){
            product*=3;
            n-=3;
        }
        product*=n;

        return product;
    }
}

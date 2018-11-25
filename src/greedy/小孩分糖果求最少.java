package greedy;

/**
 * @Desc https://leetcode.com/problems/candy/description/
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Example 1:
 *
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * @Author gcc
 * @Date 18-11-15 下午8:45
 **/
public class 小孩分糖果求最少 {
    /**
     * 主要是考虑这样的情况nums = [1, 5, 4, 3, 2]
     * 如果从左往右遍历,在nums[1]处应该分2个糖果,但是这样后面就没法分了
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int res = 0;
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        //从左往右遍历,第0个元素是不会改变的
        for (int i = 1; i < ratings.length; i++) {
            candies[i] = 1;
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        //从右往左,最后一个元素是不会改变的
        for (int i = ratings.length - 1; i > 0 ; i--) {
            if (ratings[i - 1] > ratings[i]) {
                //这个地方,必须要取较大值
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
            res += candies[i];
        }
        res += candies[0];
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 小孩分糖果求最少().candy(new int[]{1, 3, 4,5 ,2}));
    }
}

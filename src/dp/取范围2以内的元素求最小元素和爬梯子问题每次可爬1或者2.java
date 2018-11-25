package dp;

/**
 * @Description:    https://leetcode.com/problems/min-cost-climbing-stairs/description/

 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * @author:         Guchengcheng
 * @date:           2018年4月7日        下午10:31:27
 */
public class 取范围2以内的元素求最小元素和爬梯子问题每次可爬1或者2 {
    public int minCostClimbingStairs(int[] cost) {
    	int sumBefore2 = cost[0];
    	int sumBefore1 = cost[1];
    	for (int i=2; i<cost.length; i++) {
    		int temp = sumBefore1;
     		sumBefore1 = Math.min(sumBefore1, sumBefore2) + cost[i];
     		sumBefore2 = temp;
    	}
    	return Math.min(sumBefore1, sumBefore2);
    }

    public void test() {
    	System.out.println(minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1 ,100, 1}));
    }
}

package dp;



/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
   Once you pay the cost, you can either climb one or two steps. 
   You need to find minimum cost to reach the top of the floor, 
   and you can either start from the step with index 0, or the step with index 1.
   cost will have a length in the range [2, 1000]
 * @ClassName:      取范围2以内的元素求最小元素和爬梯子问题每次可爬1或者2
 * @Description:    TODO
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

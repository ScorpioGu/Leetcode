package dp;



public class ClimbingStairs {
	/**
	 * @Description:非递归做法，用两个变量存储前一步和前两步的的计算结果，相较于递归做法，减少了时间复杂度。
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n == 1) 
			return 1;
		if (n == 2)
			return 2;
		int twoHopBeforeNow = 1;
		int oneHopBeforeNow = 2;
		int nowCount = 0;
		for (int i=3; i<=n; i++) {
			nowCount = twoHopBeforeNow + oneHopBeforeNow;
			twoHopBeforeNow = oneHopBeforeNow;
			oneHopBeforeNow = nowCount;
		}
		return nowCount;
	}
	
	/**
	 * @Description:递归做法，从顶往下递归，容易理解，但是有冗余计算，比如算10要算9和8，算9又要算8和7，那相当于8被重复算了。
	 * @param n
	 * @return
	 */
	public int climbStairsRecursion(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return climbStairs(n-1) + climbStairs(n-2);
	}

    public void test() {
    	System.out.println(climbStairs(10));
    	System.out.println(climbStairsRecursion(10));
    }
}

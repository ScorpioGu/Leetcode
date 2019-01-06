package dp;



/**
 *
 * @Description:    https://leetcode.com/problems/house-robber/description/
 * @author:         Guchengcheng
 * @date:           2018年4月6日        下午8:40:15
 */
public class 偷房子 {
	/**
	 * 
	 * @Description:
	 * v[i]是第i个位置和最大的值，那么有 v[i] = max(v[i-1], v[i-2] + nums[i])
	 * 注意v[i]不一定要包含nums[i]
	 * 所以要维护两个变量，即在当前位置前一个与前两个位置的要求的最大值。每一次递推后，v[i-1] = v[i-2], v[i] = max(v[i-1], v[i-2]+nums[i])
	 * 并且一定有v[i] >= v[i-1]
	 * @param nums
	 * @return
	 */
    public int rob(int[] nums) {
    	if (nums.length == 0)
    		return 0;
    	if (nums.length == 1)
    		return nums[0];
    	int maxFirst = nums[0];
    	int maxSecond = Math.max(nums[0], nums[1]);
    	for (int i=2; i<nums.length; i++) {
    		int temp = maxSecond;
    		maxSecond = Math.max(maxFirst + nums[i], maxSecond); 
    		maxFirst = temp;
    	}
    	return maxSecond;
    }
    
    /**
     * 
     * @Description: 
     * 区分奇数偶数，实际上还是 v[i] = max(v[i-1], v[i-2]+nums[i])这个式子，但是写法上简单了很多
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
    	int odd = 0;
    	int even = 0;
    	for (int i=0; i<nums.length; i++) {
    		if (i%2 == 0)
    			even = Math.max(odd, even + nums[i]);
    		else
    			odd = Math.max(even, odd + nums[i]);
    	}
    	return Math.max(odd, even);
    }

    public void test() {
    	int[] nums = new int[] {2, 1, 1, 2};
    	System.out.println(rob(nums));
    	System.out.println(rob2(nums));
    }
}

package array;
/*
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Note: [1,2,2,3] should return 1. 
 * ThirdDistinctMaximumNumber
 */
public class 序列中第三大的数 {
    public int thirdMax(int[] nums) {
    	if(nums == null || nums.length == 0)
	    	return -1;
	    Integer max1 = null;
	    Integer max2 = null;
	    Integer max3 = null;
	    for(Integer n:nums) {
	    	//值相同元素直接跳过
	    	if(n.equals(max1) || n.equals(max2) || n.equals(max3))
	    		continue;
	    	if(max1 == null || n > max1) {
	    		max3 = max2;
	    		max2 = max1;
	    		max1 = n;
	    	} else if(max2 == null || n>max2){
	    		max3 = max2;
	    		max2 = n;
	    	} else if(max3 == null || n>max3) {
	    		max3 = n;
	    	}
    	}
    	return max3==null?max1:max3;

    }
}


package dp;
/**
 *
 * @Description: https://leetcode.com/problems/range-sum-query-immutable/
 * 求一个数组i-j范围内数值的和，要求多次调用不用重复计算。做法就是根据数组先建立一个数组存储从下标0开始到各个下标为止的数值和。
 * 那么sumRange(i, j) = vals[j] - vals[i-1],注意处理i=0的导致数组越界的情况
 * @author:         Guchengcheng
 * @date:           2018年4月7日        下午10:24:17
 */
public class 求不可变数组指定区间的元素和 {
	int[] vals;
	public 求不可变数组指定区间的元素和(int[] nums) {
		if (nums.length == 0){
			return;
		}
		vals = new int[nums.length + 1];
	    for (int i=1; i<=nums.length; i++) {
		  vals[i] = vals[i-1] + nums[i-1];
	    }
	}
	
	
	public int sumRange(int i, int j) {
		//小心处理细节问题，检查数组是否会越界
	    return vals[j+1] - vals[i];
	}
}


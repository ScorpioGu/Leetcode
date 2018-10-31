package array;

import java.util.ArrayList;
import java.util.List;
/*https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
这道题的特殊性在于，数组内的元素范围时1<=a[i]<=n,这种情况下，可以把元素值处理成元素下标。
即如果i存在，那么把第i个下标处的元素设为负的，遍历之后。只有输出值为正的元素下标就是没有出现过
的元素。扩展一下，如果元素范围时x<=a[i]<=n+x-1也没关系，平移一下即可。

这个思想很重要！！！！
 */

public class 寻找没出现过的元素_元素值下标映射 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i=0; i<nums.length; i++) {
    		//这里要绝对值，时因为第i个元素可能在之前被取负了，减1时平移，为了元素值和元素下标能够等值映射。
    		int val = Math.abs(nums[i]) - 1;
    		//如果是负的不需要处理，说明已经有这个元素了
    		if(nums[val] > 0) {
    			nums[val] = -nums[val];
    		}
    	}
    	
    	for(int i=0; i<nums.length; i++) {
    		//大于0的，其下标平移后一定是没出现过的
    		if(nums[i]>0) {
    			list.add(i+1);
    		}
    	}
       	return list;
    }
}
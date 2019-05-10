package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

public class 查找和为0的三个数集合 {
    public List<List<Integer>> threeSum(int[] nums) {
    	if(nums == null || nums.length<3) 
    		return null;
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	//排序把相邻的放一起，首尾指针移动，查找的方式，因为这题的时间复杂度为nlogn.所以排个序不影响时间复杂度
		//排个序之后再查找，一是方便快速过滤相同元素，二是节省了空间复杂du，不需要引入容器存储信息
		//twosum那题，如果先排序的话虽然节省了空间复杂度，但是时间复杂度从n变成了nlogn
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
        	if(i == 0 || (i>0&&nums[i] != nums[i-1])) {
        		int j=i+1; int k=nums.length-1; int sum = -nums[i];
        		while(j < k) {
            		if(nums[j] + nums[k] == sum) {
            			list.add(Arrays.asList(nums[i], nums[j], nums[k]));
            			//相等的元素都靠一起，移动到下一个不相同的元素
            			while(j<k && nums[j]==nums[j+1]) j++;
            			while(k>j && nums[k]==nums[k-1]) k--;
            			j++;k--;
            		} else {
            			//如果小的话，左边的移动一下，如果大的话右边的移动一个
            			if(nums[j] + nums[k] < sum) {
            				j++;
            			} else {
            				k--;
            			}
            		}
        		}
        	}
        }
        return list;
    }
}

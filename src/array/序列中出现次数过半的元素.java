package array;

/**
 * https://leetcode.com/problems/majority-element/description/
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class 序列中出现次数过半的元素 {
	/**
	 *
	 * 每找到一对不同的元素，就删除，剩下的一定是majority元素。当遇见与majority元素相同的时候，count++，
	 * 不同的时候count--。当count为0，去更换majority元素。
	 *
	 * 如果次数过半的元素不一定存在，还需要去判断一下，这里如果不存在我们返回0
	 * Moore Voting算法
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		int count=1;
		int majority = nums[0];
		for(int i=1; i<nums.length; i++) {
			if(nums[i]==majority) {
				count++;
			} else {
				count--;
			}
			if(count==0) {
				majority = nums[i];
				count++;
			}
		}
		boolean b = true;
		int times = 0;
		for (int i=0; i<nums.length; i++) {
			if (majority == nums[i]) {
				times++;
			}
		}
		if (times * 2 > nums.length) {
			b = true;
		} else {
			b = false;
		}

		return b ? majority : 0;
	}
}

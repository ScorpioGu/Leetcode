package array;
/*
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
 */
public class 序列旋转 {
	public void rotate(int[] nums, int k) {
		k = k%nums.length;
		int temp;
		//整体翻转
		for(int i=0, j=nums.length-1; i<j; i++,j--) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		//前k个数翻转
		for(int i=0, j=k-1; i<j; i++,j--) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		//后nums.length-k个数翻转
		for(int i=k, j=nums.length-1; i<j; i++,j--) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
}

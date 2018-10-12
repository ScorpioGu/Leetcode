package array;

/*
 * @Description https://leetcode.com/problems/container-with-most-water/description/
 * Input: [1,8,6,2,5,4,8,3,7]
    Output: 49
 * 一边从左移动，一边从右移动，选择更小的那一边向内移动，如果移动之后元素高度更大了，就是一个更优的结构
 * 。移动大的那边没用。
 * @Date 下午9:19 18-9-6
 * @Param
 * @return
 **/
public class 最大蓄水坐标差乘高度 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = (right-left) * Math.min(height[left], height[right]);
        while(left < right) {
        	if(height[left] < height[right]) {
        		left++;
        	} else {
        		right--;
        	}
        	int temp = (right-left) * Math.min(height[left], height[right]);
        	maxArea = Math.max(maxArea, temp);
        }
        return maxArea;
    }
}

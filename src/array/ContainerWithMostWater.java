package array;

public class ContainerWithMostWater {
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

package array;

public class 找出离目标数字最接近的三个数 {
    public int threeSumClosest(int[] nums, int target) {
        Integer first = null;
        Integer second = null;
        Integer third = null;
        for (Integer n : nums) {
            if (first == null || Math.abs(n-target) < Math.abs(first - target)) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || Math.abs(n - target) < Math.abs(second - target)) {
                third = second;
                second = n;
            } else if (third == null || Math.abs(n - target) < Math.abs(third - target)) {
                third = n;
            }
        }
        return first + second + third;
    }
}
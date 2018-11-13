package binarySearch;

/**
 * @Desc https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * @Author gcc
 * @Date 18-10-29 下午4:45
 **/
public class 有序数组中寻找和为k的两个数 {
    /**
     * 二分法的做法
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2) {
            return res;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target) {
                break;
            }
            int remain = target - numbers[i];
            int begin = i + 1, end = numbers.length - 1;
            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (numbers[mid] == remain) {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                }
                if (numbers[mid] < remain) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return res;
    }

    /**
     * 双指针的做法
     * @param num
     * @param target
     * @return
     */
    public int[] twoSum2(int[] num, int target) {
        int[] indice = new int[2];
        if (num == null || num.length < 2) return indice;
        int left = 0, right = num.length - 1;
        while (left < right) {
            int v = num[left] + num[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return indice;
    }
}

package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/description/
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */

public class 查找和为指定数的四个数 {
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (num.length < 4) return ans;
        Arrays.sort(num);
        // i,j定位前两个元素，对这两个进行筛选
        // 剩下两个元素使用双指针寻找
        for (int i = 0; i < num.length - 3; i++) {
            if (num[i] + num[i + 1] + num[i + 2] + num[i + 3] > target)
                break; //first candidate too large, search finished
            if (num[i] + num[num.length - 1] + num[num.length - 2] + num[num.length - 3] < target)
                continue; //first candidate too small
            if (i > 0 && num[i] == num[i - 1]) continue; //prevents duplicate result in ans linklist
            for (int j = i + 1; j < num.length - 2; j++) {
                if (num[i] + num[j] + num[j + 1] + num[j + 2] > target) break; //second candidate too large
                if (num[i] + num[j] + num[num.length - 1] + num[num.length - 2] < target)
                    continue; //second candidate too small
                if (j > i + 1 && num[j] == num[j - 1]) continue; //prevents duplicate results in ans linklist
                int low = j + 1, high = num.length - 1;
                while (low < high) {
                    int sum = num[i] + num[j] + num[low] + num[high];
                    if (sum == target) {
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while (low < high && num[low] == num[low + 1]) low++; //skipping over duplicate on low
                        while (low < high && num[high] == num[high - 1]) high--; //skipping over duplicate on high
                        low++;
                        high--;
                    }
                    //move window
                    else if (sum < target) low++;
                    else high--;
                }
            }
        }
        return ans;
    }
}

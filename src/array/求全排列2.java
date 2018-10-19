package array;

import java.util.ArrayList;
import java.util.List;

/**、
 * TODO
 * @Desc https://leetcode.com/problems/permutations-ii/description/
 * nums中有重复数字了，要求输出的排列不重复
 * 同一层有重复的就不管了
 * [1,1,2] [1,2,1]
 * @Author gcc
 * @Date 18-10-19 下午10:29
 **/
public class 求全排列2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        backTrack(lists, new ArrayList<Integer>(), nums);
        return lists;
    }

    private void backTrack(List<List<Integer>> lists, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            lists.add(new ArrayList<>(cur));
            return;
        } else {
            for (int i=0; i<nums.length; i++) {
                if (cur.contains(nums[i])) {
                    continue;
                }
                cur.add(nums[i]);
                backTrack(lists, cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}

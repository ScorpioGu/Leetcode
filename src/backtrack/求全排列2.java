package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**、
 * TODO
 * @Desc https://leetcode.com/problems/permutations-ii/description/
 * nums中有重复数字了，要求输出的排列不重复
 * @Author gcc
 * @Date 18-10-19 下午10:29
 **/
public class 求全排列2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        //排序是为了解决元素重复的问题
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(lists, new ArrayList<Integer>(), nums, used);
        return lists;
    }

    private void backTrack(List<List<Integer>> lists, List<Integer> cur, int[] nums, boolean[] used) {
        if (cur.size() == nums.length) {
            lists.add(new ArrayList<>(cur));
            return;
        } else {
            for (int i=0; i<nums.length; i++) {
                //这一块逻辑
                //1.已经添加过的位置不可以再添加，求全排列那题，因为输入的数组不重复，所以可以用contains方法判断，这里不行。用布尔数组来保存每个位置上是否添加的情况
                //2.并不是重复元素都不可以添加，如果前一个元素时已经使用过的，那么依然时可以添加的
                if (used[i]) {
                    continue;
                }
                if (i>0 && nums[i-1] == nums[i] && !used[i-1]) {
                    continue;
                }
                used[i] = true;
                cur.add(nums[i]);
                backTrack(lists, cur, nums, used);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
        }
    }
}

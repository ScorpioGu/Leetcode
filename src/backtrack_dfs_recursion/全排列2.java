package backtrack_dfs_recursion;

import java.util.*;

/**、
 * TODO
 * @Desc https://leetcode.com/problems/permutations-ii/description/
 * nums中有重复数字了，要求输出的排列不重复
 * @Author gcc
 * @Date 18-10-19 下午10:29
 **/
public class 全排列2 {
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
                //2.并不是重复元素都不可以添加，如果前一个元素是已经使用过的，那么依然是可以添加的

                //为什么前一个重复元素如果没有使用过，就不能添加呢？
                //比如1 1 2，第一个排列是112，这个排列开头取的是第一个1，将112添加进结果之后此时cur和used都清空了，即第一个1未被使用
                //那么此时取第二个1作为开头就不合理了
                if (used[i]) {
                    continue;
                }
                if (i>0 && nums[i-1] == nums[i] && !used[i-1]) {
                    continue;
                }
                cur.add(nums[i]);
                used[i] = true;
                backTrack(lists, cur, nums, used);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
        }
    }



    // 做法二
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList();
        }
        char[] chs = str.toCharArray();
        ArrayList<String> res = new ArrayList();
        Set<String> set = new HashSet();
        dfs(set, 0, chs);
        res.addAll(set);
        Collections.sort(res);
        return res;

    }

    private void dfs(Set<String> res, int start, char[] chs) {
        if (chs == null || chs.length == 0) {
            return;
        }

        if (start == chs.length) {
            res.add(String.valueOf(chs));
            return;
        }

        for (int i=start; i<chs.length; i++) {
            swap(chs, start, i);
            dfs(res, start+1, chs);
            swap(chs, i, start);
        }
    }

    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}

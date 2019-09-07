package array;

import java.util.LinkedList;
import java.util.List;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5184890.html
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
 * @Author gcc
 * @Date 18-11-19 下午9:54
 **/
public class 求缺失的区间 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<String>();
        // 初始化prev为lower-1，判断是否存在“第一个”区间
        // pre=-1 ,cur = any value
        int pre = lower - 1, cur = 0;
        for (int i = 0; i <= nums.length; i++) {
            // 当遍历到length时，设置curr为upper+1，判断是否存在“最后一个”区间
            cur = i == nums.length ? upper + 1 : nums[i];
            if (cur - pre > 1) {
                res.add(getRanges(pre + 1, cur - 1));
            }
            pre = cur;
        }
        return res;
    }

    private String getRanges(int from, int to){
        return from == to ? String.valueOf(from) : from + "->" + to;
    }
}

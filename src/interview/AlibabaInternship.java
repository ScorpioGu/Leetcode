package interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc 阿里实习三面笔试题
 *
 * 判断nums是否可以组成连续数字，可以打乱顺序，其中1可以当做任何数字去用
 * @Author gcc
 * @Date 19-3-22 上午10:31
 **/
public class AlibabaInternship {
    /**
     * 除了1的以外的数字不重复，使用hashset保存出现过的数字
     * 最大值与最小值的差小于length
     * @param nums
     * @return
     */
    public boolean isConsective(int[] nums) {
        if (nums == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                continue;
            }
            if (set.contains(nums[i])) {
                return false;
            } else {
                set.add(nums[i]);
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return (max - min) < nums.length ? true : false;
    }
}

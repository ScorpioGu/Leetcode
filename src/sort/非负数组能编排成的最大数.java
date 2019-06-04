package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Desc https://leetcode.com/problems/largest-number/description/
 * Given a linklist of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * @Author gcc
 * @Date 18-11-21 下午4:12
 **/
public class 非负数组能编排成的最大数 {
    /**
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(ss, new Comparator<String>() {
            // 返回值为负时，o1排在o2前面，返回值为正时，o2排在o1前面
            // 如果s1更大，我们希望o1排在o2前面，则需要返回负值，因为s2比s1小，用s2.compare(s1)返回负值
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                // 字符串的compareTo方法是按照字典序排序
                // 如果s2比s1小，返回负
                return s2.compareTo(s1);
            }
        });

        //解决全0的极端情况
        if (ss[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        return sb.toString();
    }
}

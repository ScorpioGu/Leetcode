package dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Desc https://leetcode.com/problems/russian-doll-envelopes/
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 *
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * @Author gcc
 * @Date 19-1-6 下午8:50
 **/
public class 俄罗斯套娃 {
    /**
     * 这道题有点像 最长递增子序列那道题，但是这题是需要宽度与长度都需要递增
     * 那么我们可以先按宽度排序，然后根据高度找最长递增子序列．
     *
     * 需要注意的是，如果宽度相同，高度更高是没有用的，也就是说排序之后，类似[3,4]不能排在[3,3]前面.
     * 只要宽度相同,高度越高越靠前放
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int len = 0;
        //tails[i]表示长度为i+1的递增序列末尾的数字
        int[] tails = new int[envelopes.length];
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(tails, 0, len, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            tails[index] = envelope[1];
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}

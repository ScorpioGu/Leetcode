package dp;

/**
 * @Desc 给一个数组比如[70,100,5,10]表示从左到右摊开的每一张牌，有两个人，轮流从数组中取一张，每次只能取最左边或者最右边的一张
 * 假设两个人都决定聪明，每次都会做出对全局最优的选择，问最后获胜者的值。
 * @Author gcc
 * @Date 19-5-29 上午11:30
 **/
public class 纸牌博弈 {

    /**
     * 对于摊开的牌，[l,..,r]，先取的人和后取的人，获的值并不一样。
     * 假设f(nums,l,r),s(nums,l,r)代表从[l,r]的纸牌后取，先取和后取分别可以获得的最大值
     * @param nums
     * @return
     */
    public int getValue(int[] nums) {
        return Math.max(f(nums, 0, nums.length - 1), s(nums, 0, nums.length-1));
    }

    private int f(int[] nums, int l, int r) {
        // 如果只剩一张牌了，先来的人可以直接取
        if (l == r) {
            return nums[l];
        }
        return Math.max(nums[l] + s(nums, l + 1, r), nums[r] + s(nums, l, r - 1));

    }


    private int s(int[] nums, int l, int r) {
        // 如果只剩一张牌了，肯定被先取的取走了，后取的没得取
        if (l == r) {
            return 0;
        }
        // 先取的人，取左或者取右，必然给后取的人留下较差的情况
        return Math.min(f(nums, l + 1, r), f(nums, l, r - 1));
    }


    public int getValueDP(int[] nums) {
        int len = nums.length;
        int[][] f = new int[len][len];
        int[][] s = new int[len][len];
        for (int j = 0; j < len; j++) {
            // base情况
            f[j][j] = nums[j];
            for (int i = j - 1; i >=0; j--) {
                f[i][j] = Math.max(nums[i] + s[i + 1][j], nums[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][len - 1], s[0][len - 1]);
    }

}

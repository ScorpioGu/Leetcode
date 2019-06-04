package dp;

/**
 * @Desc 寻找和最大的子矩阵
 * @Author gcc
 * @Date 19-6-4 上午9:59
 **/
public class 最大子矩阵 {
    // 仿照最大子数组那题，定义cur[i,j]为以nums[i,j]为右下角的子矩阵的最优解
    // 但这题因为是二维数组，子矩阵的上边界和左边界都未知，而最大子数组那题只有左边界未知，没有上边界这个变量。
    // 所以我们要对每一个上边界，都去求解以nums[i,j]为右下角的子矩阵的最优解。
    // 那么将整个矩阵的和想象成每一列的和相加。在新加一列和的时候，判断之前的最优和是否大于0，如果大于0，加上。
    // 如果小于0，丢弃，只取当前列。

    public static int maxSumSubMatrix(int[][] nums) {
        if (nums == null || nums[0] == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int m = nums.length, n = nums[0].length;
        for (int k = 0; k < m; k++) {
            int[] colSum = new int[n];
            for (int i = 0; i < m; i++) {
                int arraySum = 0;
                for (int j = 0; j < n; j++) {
                    colSum[j] += nums[i][j];
                    arraySum = colSum[j] + (arraySum > 0 ? arraySum : 0);
                    max = Math.max(max, arraySum);
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
        System.out.println(maxSumSubMatrix(matrix));

    }
}

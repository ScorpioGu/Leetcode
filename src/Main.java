import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n * n; i++) {
            nums[i/n][i%n] = sc.nextInt();
        }
        System.out.println(maxSumSubMatrix(nums));
    }
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
}

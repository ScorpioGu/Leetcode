import greedy.小孩分糖果求最少;
import support.TreeNode;

import java.util.*;

public class Main {
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int res = 0;
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        //从左往右遍历,第0个元素是不会改变的
        for (int i = 1; i < ratings.length; i++) {
            candies[i] = 1;
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        //从右往后遍历,最后一个元素是不会改变的
        for (int i = ratings.length - 1; i > 0 ; i--) {
            if (ratings[i] < ratings[i - 1]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);

            }
            res += candies[i];
        }
        res += candies[0];
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(candy(nums));
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = Integer.parseInt(sc.nextLine());
        String[] ss = sc.nextLine().split(" ");
        int[] nums = new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int N = nums.length;
        Arrays.sort(nums);
        int ans = nums[N-1] - nums[0];

        for (int i = 0; i < nums.length - 1; ++i) {
            int a = nums[i], b = nums[i+1];
            int high = Math.max(nums[N-1] - K, a + K);
            int low = Math.min(nums[0] + K, b - K);
            ans = Math.min(ans, high - low);
        }
        System.out.println(ans);
    }
}


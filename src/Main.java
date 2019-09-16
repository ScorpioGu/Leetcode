import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }

        System.out.println(checkPossibility(nums) ? 1 : 0);
    }

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length && count <= 1; i++) {
            //当出现前大后小时，一般时更希望把前面的元素变小而不是把后面的元素变大。因为后面元素变大的话，可能会导致之后的序列不递增
            //但是也有可能时类似于4,5,2这种情况，如果把5改成2会造成422不满足非递减
            //所以对于这种情况，只能改成455。改动前还是改动后，根据nums[i]与nums[i-2]的大小关系决定
            if (nums[i] < nums[i - 1]) {
                count++;
                if (i - 2 < 0 || nums[i] > nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count <= 1;
    }
}


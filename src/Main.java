import java.util.Arrays;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] ss = sc.nextLine().split(",");
//        int[] nums = new int[ss.length];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = Integer.parseInt(ss[i]);
//        }
//
//        System.out.println(checkPossibility(nums) ? 1 : 0);
//    }
//
//    public static boolean checkPossibility(int[] nums) {
//        int count = 0;
//        for (int i = 1; i < nums.length && count <= 1; i++) {
//            //当出现前大后小时，一般时更希望把前面的元素变小而不是把后面的元素变大。因为后面元素变大的话，可能会导致之后的序列不递增
//            //但是也有可能时类似于4,5,2这种情况，如果把5改成2会造成422不满足非递减
//            //所以对于这种情况，只能改成455。改动前还是改动后，根据nums[i]与nums[i-2]的大小关系决定
//            if (nums[i] < nums[i - 1]) {
//                count++;
//                if (i - 2 < 0 || nums[i] > nums[i - 2]) {
//                    nums[i - 1] = nums[i];
//                } else {
//                    nums[i] = nums[i - 1];
//                }
//            }
//        }
//        return count <= 1;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(",");
        String s = ss[0];
        int n = Integer.parseInt(ss[1]);
        System.out.println(convert(s, n));
    }

    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int len = s.length();
        StringBuffer[] sb = new StringBuffer[numRows];
        //这里务必要初始化
        for (int i=0; i<numRows; i++) {
            sb[i] = new StringBuffer();
        }
        int i = 0;
        //一次遍历，分两个不同阶段
        while (i < len) {
            //向下填充，j++
            for (int j = 0; j < numRows && i < len; j++) {
                sb[j].append(chars[i++]);
            }
            //向上填充，j--
            for (int j = numRows - 2; j > 0 && i < len; j--) {
                sb[j].append(chars[i++]);
            }
        }

        StringBuffer s1 = new StringBuffer();
        for (StringBuffer sbf : sb) {
            s1.append(sbf);
        }
        return s1.toString();
    }
}


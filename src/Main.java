import java.util.Arrays;
import java.util.Scanner;

public class Main {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] ss = sc.nextLine().split(",");
//        String s = ss[0];
//        int n = Integer.parseInt(ss[1]);
//        System.out.println(convert(s, n));
//    }
//
//    public static String convert(String s, int numRows) {
//        char[] chars = s.toCharArray();
//        int len = s.length();
//        StringBuffer[] sb = new StringBuffer[numRows];
//        //这里务必要初始化
//        for (int i=0; i<numRows; i++) {
//            sb[i] = new StringBuffer();
//        }
//        int i = 0;
//        //一次遍历，分两个不同阶段
//        while (i < len) {
//            //向下填充，j++
//            for (int j = 0; j < numRows && i < len; j++) {
//                sb[j].append(chars[i++]);
//            }
//            //向上填充，j--
//            for (int j = numRows - 2; j > 0 && i < len; j--) {
//                sb[j].append(chars[i++]);
//            }
//        }
//
//        StringBuffer s1 = new StringBuffer();
//        for (StringBuffer sbf : sb) {
//            s1.append(sbf);
//        }
//        return s1.toString();
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(maxLcpsLength(sc.nextLine()));
    }

    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }
}


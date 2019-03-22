package string;

/**
 * @Desc https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 输入
 * +2147483647
 *     1a33
 * 输出
 * 2147483647
 *     0
 * @Author gcc
 * @Date 19-3-21 上午9:58
 **/
public class 字符串转数字 {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] cs = str.toCharArray();
        int sig = 0;
        if (cs[0] == '-') {
            sig = 1;
        }
        int sum = 0;
        for (int i = sig; i < cs.length; i++) {
            if (cs[i] == '+') {
                continue;
            }
            if (cs[i] < '0' || cs[i] > '9') {
                return 0;
            }
            sum = sum * 10 + cs[i] - '0';
        }
        return sig == 0 ? sum : (sum * -1);
    }


}

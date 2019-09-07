package string;

/**
 * @Desc https://leetcode.com/problems/count-and-say/
 * @Author gcc
 * @Date 19-6-12 下午4:36
 **/
public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        StringBuilder sb;
        for (int i = 1; i < n; i++) {
            sb = new StringBuilder();
            int count = 1;
            char pre = s.charAt(0);
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == pre) {
                    count++;
                } else {
                    sb.append(count).append(pre);
                    pre = s.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(pre);
            s = sb.toString();
        }
        return s;
    }
}

package math;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5184698.html
 * Given two strings S and T, determine if they are both one edit distance apart.
 * @Author gcc
 * @Date 18-11-19 下午9:19
 **/
public class 判断两字符串是否只差一个编辑距离 {
    /**
     * 所谓编辑距离是指一个字符串转成另外一个字符串所需要的最小操作次数
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int delta = Math.abs(l1 - l2);
        if (delta >= 2) {
            return false;
        }
        if (delta == 0) {
            int count = 0;
            for (int i = 0; i < l1; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        } else {
            int i = 0, j = 0;
            while (i < l1 && j < l2) {
                if (s.charAt(i) != t.charAt(j)) {
                    if (l1 > l2) {
                        return s.substring(i + 1).equals(t.substring(j));
                    } else {
                        return s.substring(i).equals(t.substring(j + 1));
                    }
                }
                i++;
                j++;
            }
            return true;
        }
    }
}

package kmp;

/**
 * @Desc 给一个串s,在这个串的后面添加一些字符，添加最少的字符使得新串中包含两个s，比如abcabc
 * 最少添加三个字符abc,使其成为abcadbcadbc。
 *
 * KMP的应用
 * @Author gcc
 * @Date 19-5-26 下午4:14
 **/
public class 扩展字符串使得新字符串包含两个原串 {
    public static String answer(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chas = str.toCharArray();
        if (chas.length == 1) {
            return str + str;
        }
        if (chas.length == 2) {
            return chas[0] == chas[1] ? (str + String.valueOf(chas[0])) : (str + str);
        }
        int endNext = endNextLength(chas);
        return str + str.substring(endNext);
    }

    /**
     * 获取字符串前和后相同的字符的最大长度
     * @param chas
     * @return
     */
    public static int endNextLength(char[] chas) {
        int[] next = new int[chas.length + 1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        //待比较的位置，如果比较没有成功，cn往前跳到next[cn]处
        int cn = 0;
        while (pos < next.length) {
            if (chas[pos - 1] == chas[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                // 比较不成功往前跳
                cn = next[cn];
            } else {
                // 跳无可跳
                next[pos++] = 0;
            }
        }
        return next[next.length - 1];
    }
}

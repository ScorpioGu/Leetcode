package palindrome;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-5-26 下午5:22
 **/
public class 在字符串后添加字符使其成为最短的回文串 {

    /**
     * 字符之间添加$，方便回文判断
     * @param str
     * @return
     */
    public static char[] manacherString(String str) {
        final StringBuffer sb = new StringBuffer();
        sb.append('$');
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            sb.append('$');
        }
        return sb.toString().toCharArray();
    }

    public static String shortestEnd(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] charArr = manacherString(str);

        // pArr[i]表示以i为中心点的回文串的回文半径，满足char[i + pArr[i]] != char[i - pArr[i]]
        // 而char[i + pArr[i] - 1] == char[i - pArr[i] + 1]
        int[] pArr = new int[charArr.length];
        // 最大右边界的中心点
        int index = -1;
        // 最大右边界
        int pR = -1;
        // 最大右边界到最后了，此时的回文半径
        int maxContainsEnd = -1;
        for (int i = 0; i != charArr.length; i++) {
            // 如果i >= 右边界，则pArr[i]初始为1，后面再暴力去做
            // 如果i < 右边界，有三种情况,i关于index的对称点是2 * index - i
            // 第一种情况，pArr[2 * index - i] < pR-i，那么pArr[i]就是pArr[2 * index - i]，下面的While循环就去就会不满足条件break
            // 第一种情况，pArr[2 * index - i] > pR-i，那么pArr[i]就是pR-i，下面的While循环就去就会不满足条件break
            // 第三种情况，pArr[2 * index - i] > pR-i，那么pArr[i]至少是pR-i，是否会继续增加，还要看下面的while循环，
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;


            // 这是传统的暴力解法，如果不能利用以前的信息直接得出，则需要用暴力解法更新pArr[i]
            while (i + pArr[i] < charArr.length && i - pArr[i] >= 0) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }

            // 往外扩右边界
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }

            // 判断右边界是否到底了
            if (pR == charArr.length) {
                maxContainsEnd = pArr[i];
                break;
            }
        }
        char[] res = new char[str.length() - maxContainsEnd + 1];
        for (int i = 0; i < res.length; i++) {
            // charArr[i * 2 + 1]是真的有效的字符
            res[res.length - 1 - i] = charArr[i * 2 + 1];
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str2 = "bcatac";
        System.out.println(new 在字符串后添加字符使其成为最短的回文串().shortestPalindrome(str2));

    }

    /**
     * kmp方法
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        // 这样构成的串一定是回文的
        // 串可以分为两部分，左边部分的一段与右边部分的相应段也是回文的，或者说是字符串翻转的
        // 那么已知开头段与结尾段，只要它们长度相同，肯定开头段等于结尾段的翻转，如果本身不翻转也相等（求next数组），必然开头段本身是回文的
        String temp = new StringBuilder(s).reverse().toString() + "#" + s;
        //求next数组
        int[] table = getNextArray(temp);
        int beginIndex = table[table.length - 1];
        if (beginIndex == -1) {
            return s + new StringBuilder(s).reverse();
        }
        return s + new StringBuilder(s.substring(0, s.length() - beginIndex)).reverse().toString();
    }


    public static int[] getNextArray(String s) {
        char[] ms = s.toCharArray();
        if (ms.length == 1) {
            return new int[] { -1};
        }
        int[] next = new int[ms.length + 1];
        // 这两个固定
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }
}

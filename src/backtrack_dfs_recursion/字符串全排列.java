package backtrack_dfs_recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Desc https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @Author gcc
 * @Date 19-4-16 下午4:14
 **/
public class 字符串全排列 {
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList();
        }
        char[] chs = str.toCharArray();
        ArrayList<String> res = new ArrayList();
        if (chs == null || chs.length == 0) {
            return res;
        }

        dfs(chs, res, 0);
        return res;
    }

    /**
     * i前面的字符串固定,将字符i与后面的字符交换
     * @param chs
     * @param i
     */
    private void dfs(char[] chs, ArrayList<String> res, int i) {
        // 如果i到最后一个字符了,也没什么好交换的了
        if (i == chs.length - 1) {
            res.add(String.valueOf(chs));
            return;
        }
        //避免重复,比如abb,a只需要跟第一个b交换一次就行了
        Set<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                dfs(chs, res, i + 1);
                swap(chs, i, j);
            }
        }
    }

    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}

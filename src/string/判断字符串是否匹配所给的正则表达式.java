package string;
//https://leetcode.com/problems/regular-expression-matching/description/

//p是pattern，.代表一个任何的字符，*代表0个或多个前一个字符
//暴力法不好做阿，因为*能表示的情况太多了，也许当*为1个的时候不行，为0个的时候就行了，时间复杂度o（n）应该作不来

//考虑用动态规划，那种二维矩阵

public class 判断字符串是否匹配所给的正则表达式 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        //初始化每个格子里面是false
        boolean[][] valid = new boolean[s.length() + 1][p.length() + 1]; //valid[i][j]代表s的前i个字符与p的前j个字符匹配
        valid[0][0] = true;

        //对第一行初始化，下面要用，第一行不涉及s串，所以*的情形只有0个。
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && valid[0][i - 1]) {
                //*代表0个之前的字符
                valid[0][i+1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    valid[i + 1][j + 1] = valid[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    valid[i + 1][j + 1] = valid[i][j];
                }
                if (p.charAt(j) == '*') {
                    //如果s的新元素和p的最后一个元素不相同，要想能匹配上，*只能为0个，就是把p的最后一个删除
                    //那么是否匹配则取决于当前的s与去掉两个符号的p是否匹配
                    //其实这里也应该分*的三种情况讨论，但是因为新的两个元素都已经不同了，*为1个或者多个都没有用，所以只要考虑*为0个就可以了
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        valid[i+1][j+1] = valid[i+1][j-1];
                    } else {
                    //到这里了，则s的新元素与p的最后一个元素相同。*可以是三种情况
                    //为0是，等于把最后两个字符珊 对应于valid[i+1][j-1],
                    //为1，则是去掉最后一个字符，对应于valid[i+1][j]
                    //为多个，对应于valid[i][j+1]
                        valid[i+1][j+1] = (valid[i+1][j] || valid[i][j+1] || valid[i+1][j-1]);
                    }

                }
            }
        }
        return valid[s.length()][p.length()];
    }
}

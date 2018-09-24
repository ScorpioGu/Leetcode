package string;

//p是pattern，.代表一个任何的字符，*代表0个或多个前一个字符
//暴力法不好做阿，因为*能表示的情况太多了，也许当*为1个的时候不行，为0个的时候就行了，时间复杂度o（n）应该作不来

//考虑用动态规划，那种二维矩阵

//TODO
public class 判断字符串是否匹配所给的正则表达式 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] valid = new boolean[s.length() + 1][p.length() + 1];
        valid[0][0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {

            }
        }
    }
}

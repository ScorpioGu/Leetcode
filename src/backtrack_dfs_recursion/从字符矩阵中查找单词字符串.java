package backtrack_dfs_recursion;

/**
 * @Desc https://leetcode.com/problems/word-search/description/
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * @Author gcc
 * @Date 18-10-30 上午11:36
 **/
public class 从字符矩阵中查找单词字符串 {
    public boolean exist(char[][] board, String word) {
        char[] in = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //矩阵中的每一个位置作为出发点去尝试
                if (isExist(board, i, j, in, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isExist(char[][] board, int i, int j, char[] in, int index) {
        if (index == in.length) {
            return true;
        }
        //保证搜寻的点在范围内
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return false;
        }
        //如果当前矩阵位置和当前字符串位置的元素相等，则继续搜寻
        //上下左右四个位置都去尝试去下一个字符串位置匹配
        board[i][j] ^= 256;
        if (board[i][j] == in[index]) {
            //为避免重复访问，对访问过的元素进行异或256操作，因为board中存的字符其范围时0-255，异或了256之后
            //范围变成了[256, 511]，下次再访问该元素时一定是不相等的
            boolean exists = isExist(board, i + 1, j, in, index + 1) || isExist(board, i - 1, j, in, index + 1)
                    || isExist(board, i, j - 1, in, index + 1) || isExist(board, i, j + 1, in, index + 1);
            //还原
            return exists;
        }
        board[i][j] ^= 256;
        return false;
    }

    public static void main(String[] args) {
        char[][] in = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new 从字符矩阵中查找单词字符串().exist(in, "ABCB"));
    }
}

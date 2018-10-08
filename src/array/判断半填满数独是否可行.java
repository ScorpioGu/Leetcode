package array;

import java.util.HashSet;

/**
 * @Desc https://leetcode.com/problems/valid-sudoku/description/
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Output: true
 * @Explaination 利用HashSet存储元素的不重复，将二维数组中元素村到三种（行，列）Set中，如果存不进去说明有重复
 * 也可以用boolean数组保存，每存一个元素，该元素对应位置上则设为true。
 * @Author gcc
 * @Date 18-10-8 下午10:33
 **/
public class 判断半填满数独是否可行 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> cubeSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }

                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }

                int row = 3*(i/3);
                int col = 3*(i%3);
                if (board[row + j / 3][col + j % 3] != '.' && !cubeSet.add(board[row + j / 3][col + j % 3])) {
                    return false;
                }
            }
        }

        return true;
    }
}

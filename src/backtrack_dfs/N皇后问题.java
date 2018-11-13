package backtrack_dfs;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/n-queens/description/
 * 在n×n的矩阵中放8皇后，使其不能相互攻击。相互攻击指的是，同一横线，竖线，斜线上有其它皇后。
 * 用q代表皇后,.代表空
 * @Author gcc
 * @Date 18-10-22 下午9:28
 **/
public class N皇后问题 {
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<List<String>>();
        }
        List<List<String>> res = new ArrayList<List<String>>();
        //存放已经放置的皇后的坐标，这里用char[][]或者boolean[][]都挺好的
        Map<Integer, Integer> map = new HashMap<>();
        backTrack(res, map, n);
        return res;
    }

    private void backTrack(List<List<String>> lists, Map<Integer, Integer> map, int len) {
        int curLine = map.size();
        if (map.size() == len) {
            lists.add(convert(map));
        } else {
            for (int i = 0; i < len; i++) {
                //保证斜率不重复,只要出现一个重复的，试下一个点。
                boolean hasConfict = false;
                for (Map.Entry<Integer, Integer> e:map.entrySet()) {
                    //斜率要用double存储，否则会出现3/2 = 1的情况，不该排除的情况被排除了
                    double k = (double)(e.getKey() - curLine)/(double)(e.getValue() - i);
                    if ( k == 1 || k == -1) {
                        hasConfict = true;
                        break;
                    }
                }
                if (hasConfict) {
                    continue;
                }
                //保证垂直方向不重复
                if (map.containsValue(i)) {
                    continue;
                }
                map.put(curLine, i);
                backTrack(lists, map, len);
                map.remove(map.size() - 1);
            }
        }
    }

    private List<String> convert(Map<Integer, Integer> map) {
        List<String> list = new ArrayList<>();
        int len = map.size();

        for (int i = 0; i < len; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < len; j++) {
                sb.append(".");
            }
            sb.replace(map.get(i), map.get(i)+1, "Q");

            list.add(sb.toString());
        }
        return list;
    }


    //用数组保存当前结果，也是蛮好的
    public List<List<String>> solveNQueens2(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}

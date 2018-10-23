package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/spiral-matrix/description/
 * @Author gcc
 * @Date 18-10-23 下午6:47
 **/
public class 螺旋遍历矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin ; i--) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    list.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] test = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        List<Integer> list = new 螺旋遍历矩阵().spiralOrder(test);
        for (Integer i :
                list) {
            System.out.println(i
            );
        }
    }
}

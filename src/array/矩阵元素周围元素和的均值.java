package array;


/**
 * https://leetcode.com/problems/image-smoother/description/
 */

public class 矩阵元素周围元素和的均值 {
    public int[][] imageSmoother(int[][] M) {
        if(M == null) return null;
        int row = M.length;
        int col = M[0].length;
        int[][] rtn = new int[row][col];
        //用两个一维数组存储移动的方向信息
		int[] incrRow = {-1, 0, 1};
		int[] incrCol = {-1, 0, 1};
        for(int i=0; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		int count = 0;
        		int sum = 0;
        		//判断点自身及其周围8个位置是否在矩阵内
        		for(int m: incrRow) {
        			for(int n: incrCol) {
        				if(eleExists(m+i, n+j, row, col)) {
        					sum += M[i+m][j+n];
        				}
        			}
        		}
        		rtn[i][j] = sum/count;
        	}
        }
        return rtn;
    }

	private boolean eleExists(int x, int y, int row, int coj) {
		return x>=0 && x<row && y>=0 && y<coj;
	}
}

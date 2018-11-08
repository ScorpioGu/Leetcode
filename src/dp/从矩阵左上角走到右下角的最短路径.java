package dp;



/**
   https://leetcode.com/problems/minimum-path-sum/description/
 * @ClassName:      从矩阵左上角走到右下角的最短路径
 * @Description:    做这种dp题，就是看所求问题是不是由子问题堆叠而成的，然后找到递推式。
 * @author:         Guchengcheng
 * @date:           2018年4月8日        下午8:42:33
 */
public class 从矩阵左上角走到右下角的最短路径 {
    public int minPathSum(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	for (int i=0; i<grid.length; i++) {
    		for (int j=0; j<grid[0].length; j++) {
    			if (i == 0 && j != 0)
    				grid[i][j] += grid[i][j-1];
    			else if (j == 0 && i != 0)
    				grid[i][j] += grid[i-1][j];
    			else if (j != 0 && i != 0)
    				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
    		}
    	}
    	return grid[m-1][n-1];
    }

    public void test() {
    	System.out.println(minPathSum(new int[][] {{1, 2, 5}, {3, 2, 1}}));
    }
}

package dp;


/**
 https://leetcode.com/problems/unique-paths-ii/discuss/23250/Short-JAVA-solution
 * @ClassName:      UniquePathsII
 * @Description:    TODO
 * @author:         Guchengcheng
 * @date:           2018年4月8日        下午4:21:29
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	int[][] array = new int[m][n];
    	for (int i=0; i<m; i++) {
    		for (int j=0; j<n; j++) {
    			//先判断是否为障碍
    			if (obstacleGrid[i][j] == 1)
    				array[i][j] = 0;
    			//不是障碍的话，第一个位置为1
    			else if (i == 0 && j == 0) 
    				array[i][j] = 1;
    			//处理第一行
    			else if (i == 0)
    				array[i][j] = array[i][j-1];
    			//处理第一列
    			else if (j == 0)
    				array[i][j] = array[i-1][j];
    			else 
    				array[i][j] = array[i-1][j] + array[i][j-1];
    		}
    	}
    	return array[m-1][n-1];
    }
    
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
    	//初始化之后默认都是0,第一行时 res[j] += res[j-1] 等效于res[j] = res[j-1]
    	//第一列一定是全0获得全1或者前面一段1，后面全0
    	int[] res = new int[obstacleGrid[0].length];
    	res[0] = 1;
    	for (int[] row: obstacleGrid) {
    		for (int j=0; j<obstacleGrid[0].length; j++) {
    			if (row[j] == 1)
    				res[j] = 0;
    			else if (j>0)
    				res[j] += res[j-1];
    		}
    	}
    	return res[obstacleGrid[0].length-1];
    }

    public void test() {
    	System.out.println(uniquePathsWithObstacles(new int[][] {
    		{0, 0}, {1, 1}, {0, 0}
    	}));
    	System.out.println(uniquePathsWithObstacles2(new int[][] {
    		{0, 0}, {1, 1}, {0, 0}
    	}));
    }
}

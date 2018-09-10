package dp;


/**
 * https://leetcode.com/problems/unique-paths/description/
 * @ClassName:      从矩阵坐上角走到右下角多少种走法
 * @Description:    TODO
 * @author:         Guchengcheng
 * @date:           2018年4月8日        上午11:18:45
 */
public class 从矩阵坐上角走到右下角多少种走法 {
	/**
	 * @Description:递归做法，自顶向下，有重复计算，时间复杂度太高
	 * @param m
	 * @param n
	 * @return
	 */
    public int uniquePathsByRecursion(int m, int n) {
        if (m == 1 || n==1)
        	return 1;
        return uniquePathsByRecursion(m-1, n) + uniquePathsByRecursion(m, n-1);
    }
    
    /**
     * @Description:第i,j位置的可由第i-1,j和第i,j-1两个位置得来，这就是递推式子。使用二维数组来存储第i,j位置的步数，供递推
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
    	int[][] array = new int[m][n];
    	for (int i=0; i<m; i++) {
    		for (int j=0; j<n; j++) {
    			if (i == 0|| j==0)
    				array[i][j] = 1;
    			else
    				array[i][j] = array[i-1][j] + array[i][j-1];
    		}
    	}
    	return array[m-1][n-1];
    }
    
    /**
     * @Description:优化做法，并不需要一个二维数组，因为是先算第一行再算第二行依次，或者先算第二列再算第二列依次。那么只需要知道i行各值，第i+1行第一个值，
     * 就可以算出整个第i+1行。空间复杂度降低了。
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
    	int[] res = new int[m];
    	for (int i=0; i<m; i++) 
    		res[i] = 1;
    	for (int i=1; i<n; i++) {
    		for (int j=0; j<m; j++) {
    			if (j == 0)
    				res[j] = 1;
    			else 
    				res[j] += res[j-1];
    		}
    	}
    	return res[m-1];
    }

    public void test() {
    	System.out.println(uniquePathsByRecursion(3, 7));
    	System.out.println(uniquePaths(3, 7));
    	System.out.println(uniquePaths2(3, 7));
    }
}

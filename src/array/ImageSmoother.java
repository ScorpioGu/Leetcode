package array;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if(M == null) return null;
        int row = M.length;
        int col = M[0].length;
        int[][] rtn = new int[row][col];
		int[] incrRow = {-1, 0, 1};
		int[] incrCol = {-1, 0, 1};
        for(int i=0; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		int count = 0;
        		int sum = 0;
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

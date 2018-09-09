package array;
import java.util.*;


public class 矩阵按指定行列变形 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length == 0)
        	return null;
        if(r * c != nums.length * nums[0].length)
        	return nums;
        int[][] rtn = new int[r][c];
        int m = nums.length;
        int n = nums[0].length;
        for(int i=0; i<r*c; i++) {
        	rtn[i/c][i%c] = nums[i/n][i%n];
        }
        return rtn;
    }
}

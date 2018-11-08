package dp;

import java.util.List;

/**
 * @Desc https://leetcode.com/problems/triangle/description/
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * @Author gcc
 * @Date 18-11-8 上午10:50
 **/
public class 三角中的最短路径 {


    /**
     * 从下往上遍历,遍历到最上层直接得到结果
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int length = triangle.get(height - 1).size();
        //这里长度为length+1,最后一个位置为0,这样在边界处便不用再去判断
        int[] min = new int[length + 1];
        for(int i = height - 1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
            }
        }
        return min[0];
    }
}

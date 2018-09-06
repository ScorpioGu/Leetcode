/**
 * Author:   gucheng
 * Date:     18-4-30 下午7:18
 * Description: https://leetcode.com/problems/unique-binary-search-trees/description/
 * 卡特兰树
 */
package Tree;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - 1 - j];
            }
        }
        return res[n];
    }


}

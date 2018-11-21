/**
 * Author:   gucheng
 * Date:     18-4-30 下午7:18
 * Description: https://leetcode.com/problems/unique-binary-search-trees/description/
 * 卡特兰树
 * 1..n n个数可以构成多少不一样的BST
 * 动态规划的方式，1..n  n个树，对于每一个i都可以作为root节点，那么1-i-1都在左子数，i+1-n都在右子树。
 * 用G（n）表示n个树可以构成BST的个数，F（i,n）表示当i作为root节点时n个数可以构成BST的个数。
 * 显然G(n) = F(1,n) + F(2,n) + ... + F(n,n)
 * 而当i作为root节点时，左子树（i-1个节点）必须也要是BST,则有G(i-1)中组合方式，右子数（n-i个节点）必须也要是BST。则有G(n-i)中组合方式
 * 即F(i,n) = G(i-1) * G(n-i)
 *
 * 综合以上两式子，可得G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n-1) * G(0)
 *
 * 初始条件为G(0) = 1, G(1) = 1
 * null也时一颗BST
 */
package tree;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 * 卡特兰数
 */
public class n个数可组成的BST个数 {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        //res[i]记录i个节点能够组成的不同BST的个数
        //将0,...,i分成两端,一段是0-j, 另一段是j+1 - i,则它们各自组成BST的方式有res[j], res[i - 1 - j]种
        //又因为是组成BST,所以res[i] += res[j] * res[i - 1 - j],其中j属于[0, i)
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

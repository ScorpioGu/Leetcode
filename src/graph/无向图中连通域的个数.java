package graph;

/**
 * @Desc https://segmentfault.com/a/1190000004224298
 * @Author gcc
 * @Date 19-1-3 上午11:31
 **/
public class 无向图中连通域的个数 {
    public int countComponents(int n, int[][] edges) {
        //id数组记录每个点的父节点
        //如果最后,id[i] = i,那么说明i是根节点
        //有多少个根节点就有多少个连通域
        int[] id = new int[n];

        // 初始化
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }

        // union
        for (int[] edge : edges) {
            //对每条边的两个端点联合查找,找到各自的根节点
            int i = root(id, edge[0]);
            int j = root(id, edge[1]);
            id[i] = j;
        }

        // 统计根节点个数
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (id[i] == i)
                count++;
        }
        return count;
    }

    // 找根节点
    public int root(int[] id, int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}

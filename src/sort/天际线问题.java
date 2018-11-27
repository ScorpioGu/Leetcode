package sort;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/the-skyline-problem/description/
 * 问题太长,还是看链接吧
 * @Author gcc
 * @Date 18-11-26 下午1:17
 **/
public class 天际线问题 {
    /**
     * http://www.cnblogs.com/grandyang/p/4534586.html
     * 对着图看代码,效果更佳
     * @param buildings
     * @return
     */
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList<>();
        //height存放左顶点与右顶点
        List<int[]> height = new LinkedList<>();

        for (int[] building : buildings) {
            //为区分左右顶点,左顶点加入时其高度取相反数
            height.add(new int[]{building[0], -building[2]});
            height.add(new int[]{building[1], building[2]});
        }

        Collections.sort(height, new Comparator<int[]>() {
            @Override
            //根据横坐标排序
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        //堆顶存放当前的最大高度
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //初始化地平线作为堆顶
        queue.offer(0);
        //prev存储上一次的最大高度
        int prev = 0;
        for (int[] point : height) {
            if (point[1] < 0) {
                //是左顶点则将其高度加入堆
                queue.offer(-point[1]);
            } else {
                //是右顶点则将对应的左顶点高度移除堆
                queue.remove(point[1]);
            }

            //若最大高度发生了变化,则是加入了一个更高的节点进来了,将这个点的加进来
            if (prev != queue.peek()) {
                res.add(new int[]{point[0], queue.peek()});
                prev = queue.peek();
            }
        }
        return res;
    }
}

package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc https://leetcode.com/problems/course-schedule/description/
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a linklist of prerequisite pairs, is it possible for you to finish all courses?
 * Example 1:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * @Author gcc
 * @Date 18-11-23 下午8:25
 **/
public class 判断有向图是否成环 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //graph[i][j]为1时代表,i->j有一条边
        int[][] graph = new int[numCourses][numCourses];
        //indegrees[i]代表i这个点的入度
        int[] indegrees = new int[numCourses];

        //初始化
        for (int i = 0; i < prerequisites.length; i++) {
            int out = prerequisites[i][1];
            int in = prerequisites[i][0];

            indegrees[in]++;
            graph[out][in] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        //所有入度为0的入队
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        //BFS
        int count = 0;
        while (!queue.isEmpty()) {
            int out = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                //边如果存在的话,删掉这条边,即入点的入度减1
                if (graph[out][i] == 1) {
                    if (--indegrees[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;
    }
}

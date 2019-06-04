package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc https://leetcode.com/problems/course-schedule-ii/description/
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a linklist of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * @Author gcc
 * @Date 18-11-23 下午10:28
 **/
public class 拓扑排序 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
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
            res[count++] = out;
            for (int i = 0; i < numCourses; i++) {
                //边如果存在的话,删掉这条边,即入点的入度减1
                if (graph[out][i] == 1) {
                    if (--indegrees[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        if (count == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}

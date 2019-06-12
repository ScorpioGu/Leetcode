package greedy;

import java.util.Arrays;

/**
 * @Desc https://leetcode.com/problems/task-scheduler/
 * https://www.cnblogs.com/grandyang/p/7098764.html
 * @Author gcc
 * @Date 19-6-10 下午8:56
 **/
public class 任务调度花费最少时间段 {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts['Z' - task]++;
        }
        Arrays.sort(counts);

        int i = 25;
        while (i >=0 && counts[i] == counts[25]) {
            i--;
        }

        return Math.max(tasks.length, (n + 1) * (counts[25] - 1) + 25 - i);
    }
}

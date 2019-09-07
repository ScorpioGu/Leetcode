package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/queue-reconstruction-by-height/
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 * @Author gcc
 * @Date 19-6-9 上午11:08
 **/
public class 按高度重建队列 {

    public int[][] reconstructQueue(int[][] people) {

        // people[0]是高度，people[1]是站它前面并且比他高的人的个数

        // 按高度从大到小排序，如果高度相同，按第二个元素从小到大排序
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));

        List<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            // 高度按高到低排序的作用就是：低元素在插入后，有可能会把高元素往后面位置挤，如果高的元素被挤后了，它的第二个元素是不会变的。因为新插入的元素没他高
            // 而如果从低到高插入就会有问题。如果高度相同，按第二个元素从小到大排序，也是同样的目的。
            list.add(person[1], person);
        }

        return list.toArray(new int[people.length][]);
    }
}

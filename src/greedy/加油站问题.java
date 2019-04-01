package greedy;

/**
 * @Desc https://leetcode.com/problems/gas-station/description/
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 *
 * Note:
 *
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 *
 * Example 1:
 *
 * Input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * Output: 3
 * @Author gcc
 * @Date 18-11-15 下午7:57
 **/
public class 加油站问题 {
    /**
     * 1.如果总的gas大于总的cost，那么一定会存在一个起点，从这个起点出发可以走完全程
     * 2.从A点出发，如果B是第一个无法到达的路径，那么A-B中任意一点出发也无法到达B
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //total记录所有的站点的加油与耗油的差值, sum记录从start开始的所有站点的加油与耗油的差值
        //start为开始的站点的索引
        if (gas == null || cost == null) {
            return -1;
        }
        int total = 0, cur = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            //如果sum < 0,则从start到当前点中的任何一个都不可以作为起点,需要重新指定start点
            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
        }
        //如果total是小于0的,则一定无解,大于等于0则一定有解
        if (total < 0) {
            return -1;
        } else {
            return start;
        }
    }
}

package design;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 *
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 * @Author gcc
 * @Date 19-1-8 上午11:43
 **/
public class 嵌套列表求权重和 {
    /**
     * dfs的做法
     * @param nestedList
     * @return
     */
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    public int dfs(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger e : nestedList) {
            if (e.isInteger()) {
                sum += e.getInteger() * depth;
            } else {
                sum += dfs(e.getList(), depth + 1);
            }
        }
        return sum;
    }


    public int depthSum2(List<NestedInteger> nestedList) {
        int unweightSum = 0, weightSum = 0;
        List<NestedInteger> nextLevel = new ArrayList<>();
        while (!nestedList.isEmpty()) {
            for (NestedInteger e : nestedList) {
                if (e.isInteger()) {
                    unweightSum += e.getInteger();
                } else {
                    nextLevel.addAll(e.getList());
                }
            }
            weightSum += unweightSum;
            nestedList = nextLevel;
            nextLevel.clear();
        }
        return weightSum;
    }
}

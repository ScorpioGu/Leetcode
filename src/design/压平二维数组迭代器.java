package design;

import java.util.Iterator;
import java.util.List;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5209621.html
 * Implement an iterator to flatten a 2d vector.
 * <p>
 * For example,
 * Given 2d vector =
 * <p>
 * [
 * [1,2],
 * [3],
 * [4,5,6]
 * ]
 * <p>
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 * @Author gcc
 * @Date 19-6-12 下午4:54
 **/
public class 压平二维数组迭代器 implements Iterator {
    private List<List<Integer>> list;
    private int curLine = 0;
    private int curElem = 0;

    public 压平二维数组迭代器(List<List<Integer>> vec2d) {
        this.list = vec2d;
    }

    @Override
    public Integer next() {
        return list.get(curLine).get(curElem++);
    }

    @Override
    public boolean hasNext() {
        while (curLine < list.size()) {
            if (curElem < list.get(curLine).size()) {
                return true;
            } else {
                curLine++;
                curElem = 0;
            }
        }
        return false;
    }
}
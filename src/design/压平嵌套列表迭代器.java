package design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/flatten-nested-list-iterator/
 * Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,4,6].
 *
 * 最容易想到的方式是通过回溯将所有整数存放到list中,但是这样的方式会存储空间太大
 * 因为我们要实现的是第一个迭代器,所有元素只需要访问一次即可不用再去存储,所以list存储所有
 * 元素必然不是一个很好的方式.
 *
 * 实际上我们只需要使用stack存储NestedInteger类型,在需要的时候再将其铺平
 * @Author gcc
 * @Date 19-1-6 上午11:54
 **/
public class 压平嵌套列表迭代器 implements Iterator<Integer> {
    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     * 这告诉我们在调用next之前要先调用hasNext,那么在hasNext方法中可以进行铺平操作
     */
    private Stack<NestedInteger> stack = new Stack<>();
    public 压平嵌套列表迭代器(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0 ; i--) {
            stack.push(nestedList.get(i));
        }
    }


    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger i = stack.peek();
            if (i.isInteger()) {
                return true;
            }
            //如果不是数字,需要先把它pop出来
            stack.pop();

            for (int j = i.getList().size() - 1; j >= 0 ; j--) {
                stack.push(i.getList().get(j));
            }
        }
        return false;
    }
}


  interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      List<NestedInteger> getList();
  }

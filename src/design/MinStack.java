package design;

import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/min-stack/description/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * 这道题目的点在于如何o(1)的时间复杂度获得最小值,插入的时候可以一直去更新最小值
 * 但是删除之后更新最小值是一个问题.所以首先的一个想法就是将所有出现过的最小值保存起来,这样当一个最小值被删除了,次小值就可以去充当最小值了
 * 同样使用栈来存储
 *
 * @Author gcc
 * @Date 18-11-19 下午4:21
 **/
public class MinStack {
    /**
     * 两个栈的做法
     */
    private Stack<Integer> vals;
    /**
     * mins的栈顶存放当前的最小值
     */
    private Stack<Integer> mins;
    public MinStack() {
        vals = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        vals.push(x);
        //这里的mins.peek()一定得是>=,当有多个相同的最小值时,保证删掉一个还有其他的相同的最小值
        if (mins.isEmpty() || mins.peek() >= x) {
            mins.push(x);
        }
    }

    public void pop() {
        //注意不可以写成if(mins.peek() == vals.peek())哦,因为peek()返回的是Object对象(在这里是Integer对象)
        //先把Integer解包成int再去比较就没问题啦
        int x = vals.pop();
        if (mins.peek() == x) {
            mins.pop();
        }
    }

    public int top() {
        return vals.peek();
    }

    public int getMin() {
        if (mins.isEmpty()) {
            return 0;
        } else {
            return mins.peek();
        }
    }



}

class MinStack2 {
    /**
     * 一个栈的做法
     */
    private Stack<Integer> vals;
    private int min = Integer.MAX_VALUE;

    public MinStack2() {
        vals = new Stack<>();
    }

    public void push(int x) {
        //如果新值比min小,则先将min入栈之后再入新值
        //实际上就是借助了栈,在最小的元素的下方存储了一个冗余的次最小值
        //在出栈的时候,如果出的是最小值,则还需要将它下方的冗余的次最小值出栈了
        if (x < min) {
            vals.push(min);
            min = x;
        }
        //否则的话,就直接压入新值
        vals.push(x);
    }

    public void pop() {
        //如果出栈的值不等于min,直接出栈就行了
        int x = vals.pop();
        //否则,还需要再出栈一个,并更新min
        if (x == min) {
            min = vals.pop();
        }
    }

    public int top() {
        return vals.peek();
    }

    public int getMin() {
        return min;
    }



}




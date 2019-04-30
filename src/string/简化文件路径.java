package string;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/simplify-path/description/
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * path = "/a/../../b/../c//.//", => "/c"
 * path = "/a//b////c/d//././/..", => "/a/b/c"
 * .代表当前路径可以忽略，连续的/可以看做一个/
 * @Author gcc
 * @Date 18-10-24 下午10:12
 **/
public class 简化文件路径 {
    public String simplifyPath(String path) {
        //双端队列可以用作栈
        Deque<String> stack = new LinkedList();
        //如果是“.”或者“”，不添加就ok,".."则从栈中pop处一个元素
        Set<String> set = new HashSet<>(Arrays.asList(".", "..", ""));
        for (String s : path.split("/")) {
            if ("..".equals(s) && !stack.isEmpty()) {
                stack.pop();
            } else if (!set.contains(s)) {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();

        //倒序迭代，如果顺序输出的话，因为是栈结构先输出的是栈顶最后输出栈底
        if (stack.isEmpty()) {
            return "/";
        }
        //Deque是双端队列，可以获得倒序的迭代器
        Iterator<String> it = stack.descendingIterator();
        while (it.hasNext()) {
            sb.append("/").append(it.next());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new 简化文件路径().simplifyPath("/abc/..."));
    }
}

package backtrack_dfs_recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/different-ways-to-add-parentheses/
 * Example 1:
 * <p>
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 * <p>
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * @Author gcc
 * @Date 18-12-3 下午4:34
 **/
public class 一个计算表达式的多种算法 {
    /**
     * 卡特兰树,遇到一个计算符号,递归求出其左边两边的List.再使用两个list中的结果进行运算,计算结果添加到自己的list中
     * Base情况是输入字符串是一个单个的数字字符,那么list中就是它自己这个数字
     */
    Map<String, List<Integer>> memory = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            return new ArrayList<>();
        }
        if (memory.containsKey(input)) {
            return memory.get(input);
        }
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> leftRes = diffWaysToCompute(left);
                List<Integer> rightRes = diffWaysToCompute(right);
                for (Integer leftRe : leftRes) {
                    for (Integer rightRe : rightRes) {
                        int temp = 0;
                        switch (cur) {
                            case '+':
                                temp = leftRe + rightRe;
                                break;
                            case '-':
                                temp = leftRe - rightRe;
                                break;
                            case '*':
                                temp = leftRe * rightRe;
                                break;
                        }
                        res.add(temp);
                    }
                }
            }
        }
        //递归的基本情况,就是输入字符串是一个数字字符
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        memory.put(input, res);
        return res;
    }
}

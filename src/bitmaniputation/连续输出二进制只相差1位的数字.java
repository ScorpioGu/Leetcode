package bitmaniputation;

import java.util.LinkedList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/gray-code/description/
 * @Author gcc
 * @Date 18-11-2 上午10:44
 **/
public class 连续输出二进制只相差1位的数字 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) {
            result.add(i ^ i>>1);
        }
        return result;
    }
}

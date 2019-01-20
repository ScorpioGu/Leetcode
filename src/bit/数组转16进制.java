package bit;

/**
 * @Desc https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 * Example 1:
 *
 * Input:
 * 26
 *
 * Output:
 * "1a"
 * @Author gcc
 * @Date 19-1-14 下午11:16
 **/
public class 数组转16进制 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }
}

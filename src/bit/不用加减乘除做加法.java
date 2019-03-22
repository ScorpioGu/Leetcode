package bit;

/**
 * @Desc https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @Author gcc
 * @Date 19-3-21 上午9:45
 **/
public class 不用加减乘除做加法 {
    public int add(int num1,int num2) {
        while (num2 != 0) {
            // temp 存储不考虑进位的情况下的两数各位相加的情况,若进位为0，则temp就是最终结果
            int temp = num1 ^ num2;
            // num2 存储两数相加进位的情况，因为进位产生的1放在更高的1位上，所有需要整体左移一位
            num2 = (num1 & num2) << 1;
            // 只有当进位为0时才可以跳出循环。和=进位 + 非进位，若进位不为0，相加之后可能会产生新的进位
            num1 = temp;
        }
        return num1;
    }
}

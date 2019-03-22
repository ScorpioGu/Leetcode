package findByIndex;

/**
 * @Desc https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @Author gcc
 * @Date 19-3-21 上午11:11
 **/
public class 寻找重复的元素 {
    /**
     * 如果要求所有重复的元素，用遍历过程完了之后，用list存一下所有小于0的元素对应的下标就行了，和
     * 那题寻找从没出现过的元素是一个意思
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        // 若numbers[i]处的值小于0，说明i出现过
        for (int i = 0; i < length; i++) {
            // 当前的数对应的位置
            int index = numbers[i];
            // 若i之前出现过，则index小于0，需要将其还原
            if (index < 0) {
                index = -(index + 1);
            }

            if (numbers[index] < 0) {
                duplication[0] = index;
                return true;
            }
            // numbers[i]可能为0，直接取负没有效果，所以再减了个1
            // numbers[index] 小于 标识index这个值之前出现过
            numbers[index] = -(numbers[index]) - 1;
        }
        return false;
    }
}

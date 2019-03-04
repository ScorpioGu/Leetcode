package array;

/**
 * @Desc https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @Author gcc
 * @Date 19-3-4 下午2:38
 **/
public class 扑克牌顺子 {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        // 连续需要满足条件
        // 1.除0以外，所有元素不重复
        // 2.numbers中的最大值与最小值 小于5
        // 3.所有元素介于[0, 13]
        // 4.numbers长度必须为5
        int max = -1, min = 14;

        // count的第i位若为0表示i未出现过，若为1表示i已经出现
        int count = 0;
        for (int i=0; i<numbers.length; i++){
            if (numbers[i] > 13 || numbers[i] < 0) {
                return false;
            }
            if (numbers[i] == 0) {
                continue;
            }
            if (((count >> numbers[i]) & 1) == 1) {
                return false;
            }
            count |= 1<<numbers[i];
            max = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
        }

        if (max - min < 5) {
            return true;
        }

        return false;

    }
}

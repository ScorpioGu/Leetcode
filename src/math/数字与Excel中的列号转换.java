package math;

/**
 * @Desc https://leetcode.com/problems/excel-sheet-column-title/description/
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 * @Author gcc
 * @Date 18-11-20 下午5:27
 **/
public class 数字与Excel中的列号转换 {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        //先插入最后的数,
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }

    public int convertToNumber(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (char c : chars) {
            res *= 26;
            res += c - 'A' + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 数字与Excel中的列号转换().convertToNumber("Z"));
    }
}

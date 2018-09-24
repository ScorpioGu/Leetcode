package string;

//https://leetcode.com/problems/zigzag-conversion/description/
/*Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
        Explanation:

        P     I    N
        A   L S  I G
        Y A   H R
        P     I*/
public class 字符串z字型排列 {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int len = s.length();
        StringBuffer[] sb = new StringBuffer[numRows];
        //这里务必要初始化
        for (int i=0; i<numRows; i++) {
            sb[i] = new StringBuffer();
        }
        int i = 0;
        //一次遍历，分两个不同阶段
        while (i < len) {
            //向下填充，j++
            for (int j = 0; j < numRows && i < len; j++) {
                sb[j].append(chars[i++]);
            }
            //向上填充，j--
            for (int j = numRows - 2; j > 0 && i < len; j--) {
                sb[j].append(chars[i++]);
            }
        }

        StringBuffer s1 = new StringBuffer();
        for (StringBuffer sbf : sb) {
            s1.append(sbf);
        }
        return s1.toString();
    }
}

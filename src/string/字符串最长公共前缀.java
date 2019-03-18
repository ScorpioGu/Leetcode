package string;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class 字符串最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        //对第一个字符串不断截尾，直到它是每个字符串的公共前缀
        for(int i=1; i<strs.length; i++) {
        	while(strs[i].indexOf(pre) != 0) {
        		pre = pre.substring(0, pre.length()-1);
        	}
        }
        return pre;
    }
}

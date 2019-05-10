package string;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class 最长公共前缀LCP {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        //对第一个字符串不断截尾，直到它是每个字符串的公共前缀
        for(int i=1; i<strs.length; i++) {
            // 如果strs[i].indexOf(pre)==0，则pre是strs[i]的前缀
            // 否则pre截掉尾部的一个字符，继续比较

            //str.indexof(pre)返回的是pre第一次在str出现的位置，如果为0，则pre是str的前缀
        	while(strs[i].indexOf(pre) != 0) {
        		pre = pre.substring(0, pre.length()-1);
        	}
        }
        return pre;
    }
}

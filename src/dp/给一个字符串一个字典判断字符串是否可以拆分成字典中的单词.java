package dp;

import java.util.List;

/**
 * https://leetcode.com/problems/word-break/description/
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class 给一个字符串一个字典判断字符串是否可以拆分成字典中的单词 {
    public boolean wordBreak(String s, List<String> wordDict) {
    	boolean[] history = new boolean[s.length()+1];
    	//history[i]表示前i个字符组成的字符串是否成功
    	history[0] = true;
    	for (int i=1; i<=s.length(); i++) {
    		for (int j=0; j<i; j++) {
    			if (history[j] && wordDict.contains(s.substring(j, i))) {
    				history[i] = true;
    				//但凡可以找到一种拆分的方式就可以跳出循环
    				break;
    			}
    		}
    	}
    	
    	return history[s.length()];
    }
}

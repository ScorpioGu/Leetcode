package string;

import java.util.HashMap;
import java.util.Map;
/**
 *https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class 最长不含重复字符的字符串的长度 {
    public int lengthOfLongestSubstring(String s) {
    	if(s == null || s.length() == 0) {
			return 0;
		}
		// 存储每个字符最先出现的位置
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	int max = 0;
		//j记录的当前这个串的起始位置
    	int j = 0;
    	for(int i=0; i<s.length(); i++) {
    		if(map.containsKey(s.charAt(i))) {
    			 //当发现重复元素但是重复元素在当前子串的起始位置之前，子串的起始位置时不需要变的
				//只有当重复元素的位置大于j时，子串需要改变，因为当前子串中存在了重复字符
    			 j = Math.max(j,map.get(s.charAt(i))+1);
    		}
    		map.put(s.charAt(i), i);
    		max = Math.max(max, i-j+1);
    	}
    	return max;
    }
}

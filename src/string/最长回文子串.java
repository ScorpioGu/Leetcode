package string;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class 最长回文子串 {
	int begin;
	int maxLen;
    public String longestPalindrome(String s) {
    	int len = s.length();
		if (len < 2) {
			return s;
		}

    	//i循环到倒数第二个位置，最后一个元素上扩展回文串没有意义，而且会造成数组越界
    	for(int i=0; i<len-1; i++) {
			//奇数的情况
    		findPalString(s, i, i);
			//偶数的情况
    		findPalString(s, i, i+1);
    	}
    	return s.substring(begin, begin + maxLen);
    }

	/**
	 * 	这个方法的意意思是字符串s的j-k这段子串，向外扩展回文串
	 */
    private void findPalString(String s, int j, int k) {
    	while(j>=0 && k<s.length() && s.charAt(j) == s.charAt(k)) {
    		j--;
    		k++;
    	}
    	//注意上述while执行完毕之后，j停在回文串开头的前一个位置，k停在回文串结尾的下一个位置
		//实际的回文串开始于j+1，长度为k-j-1
    	if(maxLen < k-j-1) {
    		maxLen = k-j-1;
    		begin = j+1;
    	}
    }
    
}
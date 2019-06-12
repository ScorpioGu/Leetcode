package palindrome;

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
		for (int i = 0; i < len - 1; i++) {
			//奇数的情况
			findPalString(s, i, i);
			//偶数的情况
			findPalString(s, i, i + 1);
		}
		return s.substring(begin, begin + maxLen);
	}

	/**
	 * 这个方法的意意思是字符串s的j-k这段子串，向外扩展回文串
	 */
	private void findPalString(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		//注意上述while执行完毕之后，j停在回文串开头的前一个位置，k停在回文串结尾的下一个位置
		//实际的回文串开始于j+1，长度为k-j-1
		if (maxLen < k - j - 1) {
			maxLen = k - j - 1;
			begin = j + 1;
		}
	}


	public String longestPalindrome2(String s) {
		if (s == null || s.length() <= 1) return s;
		s = process(s);
		int[] P = new int[s.length()];
		int mid = 0;
		int max = 0;
		for (int i = 1; i < s.length() - 1; i++) {
			P[i] = i < max ? Math.min(P[mid - (i - mid)], max - i) : 0;
			while (s.charAt(i - P[i] - 1) == s.charAt(i + P[i] + 1)) P[i]++;
			if (i + P[i] > max) {
				mid = i;
				max = P[i];
			}
		}
		int maxLen = 0;
		mid = 0;
		for (int i = 0; i < s.length(); i++) {
			if (P[i] > maxLen) {
				mid = i;
				maxLen = P[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = mid - maxLen; i <= mid + maxLen; i++) {
			if (s.charAt(i) != '#') sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	private String process(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append('^');
		for (int i = 0; i < s.length(); i++) {
			sb.append('#');
			sb.append(s.charAt(i));
		}
		sb.append("#$");
		return sb.toString();
	}
}
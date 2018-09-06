package string;

public class LongestPalindromicSubstring {
	int begin;
	int maxLen;
    public String longestPalindrome(String s) {
    	int len = s.length();
    	if(len < 2) return s;
    	
    	for(int i=0; i<len-1; i++) {
    		findPalString(s, i, i);
    		findPalString(s, i, i+1);
    	}
    	return s.substring(begin, begin + maxLen);
    }
    
    private void findPalString(String s, int j, int k) {
    	while(j>=0 && k<s.length() && s.charAt(j) == s.charAt(k)) {
    		j--;
    		k++;
    	}
    	if(maxLen < k-j-1) {
    		maxLen = k-j-1;
    		begin = j+1;
    	}
    }
    
}
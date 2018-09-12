package string;

//回文串有可能时奇数长度也有可能时偶数长度
public class 最长回文串 {
	int begin;
	int maxLen;
    public String longestPalindrome(String s) {
    	int len = s.length();
    	if(len < 2) return s;
    	
    	for(int i=0; i<len-1; i++) { //注意i最多循环到倒数第二个位置，最后一个位置寻找没有意思，而且会数组越界
    		findPalString(s, i, i); //单个字符向外扩展，对应奇数长度的回文串
    		findPalString(s, i, i+1); //连续的两个字符向外扩展，对应偶数长度的回文串
    	}
    	return s.substring(begin, begin + maxLen);
    }

    //j往左，k往右扩展，如果j,k两处元素相等，则继续扩展该回文串。
    private void findPalString(String s, int j, int k) {
    	while(j>=0 && k<s.length() && s.charAt(j) == s.charAt(k)) {
    		j--;
    		k++;
    	}
    	//注意此时j停在回文串之前一个位置，k停在回文串之后一个位置，回文串的开始是j+1,结尾是k-1，长度是k-j-1
    	if(maxLen < k-j-1) {
    		maxLen = k-j-1;
    		begin = j+1;
    	}
    }
    
}
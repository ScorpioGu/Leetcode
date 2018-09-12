package string;

public class 求字符串的最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) 
        	return "";
        String pre = strs[0];
        //对第一个字符串不断切尾，直到成为某个子串的前缀
        for(int i=1; i<strs.length; i++) {
        	while(strs[i].indexOf(pre) != 0) {
        		pre = pre.substring(0, pre.length()-1);
        	}
        	i++;
        }
        return pre;
    }
}

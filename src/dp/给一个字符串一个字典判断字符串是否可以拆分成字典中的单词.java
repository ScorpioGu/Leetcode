package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class 给一个字符串一个字典判断字符串是否可以拆分成字典中的单词 {
    public boolean wordBreak(String s, List<String> wordDict) {
    	boolean[] history = new boolean[s.length()+1];
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

    public void test() {
    	List<String> list = new ArrayList<String>(Arrays.asList("aaa", "aaaa"));
    	System.out.println(wordBreak("aaaaaaa", list));
    }
}

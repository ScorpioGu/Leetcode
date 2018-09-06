package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
    	boolean[] history = new boolean[s.length()+1];
    	history[0] = true;
    	for (int i=1; i<=s.length(); i++) {
    		for (int j=0; j<i; j++) {
    			if (history[j] && wordDict.contains(s.substring(j, i))) {
    				history[i] = true;
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

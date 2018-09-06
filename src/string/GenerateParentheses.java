package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
    	List<String> list = new ArrayList<String>();
    	backtrack(list, "", 0, 0, n);
    	return list;
    }

    private void backtrack(List<String> list, String str, int open, int close, int max) {
    	if(str.length() == 2*max) {
    		list.add(str);
    		System.out.println(str);
    		return;
    	}
    	
    	if(open < max) {
    		backtrack(list, str+"(", open+1, close, max);
    	}
    	
    	if(close < open) {
    		backtrack(list, str+")", open, close+1, max);
    	}
    }
    
    public static void main(String[] args) {
    	new GenerateParentheses().generateParenthesis(3);
	}
}

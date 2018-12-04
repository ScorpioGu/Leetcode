package string;

import java.util.ArrayList;
import java.util.List;

public class n对括号输出每种对称的组合方式 {
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

    	//只要open<max，就可以继续添加open
    	if(open < max) {
    		backtrack(list, str+"(", open+1, close, max);
    	}

    	//close<open，要补close来平衡
    	if(close < open) {
    		backtrack(list, str+")", open, close+1, max);
    	}

    	//一旦出现close > open,就没救了，没法补救
    }
    
    public static void main(String[] args) {
    	new n对括号输出每种对称的组合方式().generateParenthesis(3);
	}
}

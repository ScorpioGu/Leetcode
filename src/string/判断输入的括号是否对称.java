package string;

import java.util.Stack;

public class 判断输入的括号是否对称 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()) {
        	if(stack.isEmpty() || !isMatchedBrackets(stack.peek(), c)) { 
        		stack.push(c);
        	} else {
            	stack.pop();
        	}
        }
        return (stack.isEmpty());
    } 
    
    private boolean isMatchedBrackets(char c1, char c2) {
    	if(c1 == '(' && c2 == ')') 
    		return true;
    	if(c1 == '{' && c2 == '}') 
    		return true;
    	if(c1 == '[' && c2 == ']') 
    		return true;
    	return false;
    }

	/**
	 * 也可以使用一个变量计树，记录的是当前左括号－右括号的数量，一旦这个值小于０，必然不匹配，不用继续往下走了
	 * @param s
	 * @return
	 */
	public boolean isValid２(String s) {
		int status = 0;
		char[] chas = s.toCharArray();
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] != ')' && chas[i] != '(') {
				return false;
			}
			if (chas[i] == ')' && --status < 0) {
				return false;
			}
			if (chas[i] == '(') {
				status++;
			}
		}
		return status == 0;
	}


}

package string;

import java.util.Stack;

public class ValidParentheses {
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

}

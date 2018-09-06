package array;

import java.util.LinkedList;
import java.util.List;

public class 电话号码映射到手机键盘字符组合 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<String>();
        if (digits.length()==0){
        	return queue;
        }
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        queue.add("");
        for(int i=0; i<digits.length(); i++) {
        	int key = Character.getNumericValue(digits.charAt(i));
        	while(queue.peek().length() == i) {
        		String t = queue.remove();
        		for(char s: map[key].toCharArray()) {
        			queue.offer(t+s);
        		}
        	}
        }
        return queue;
    }
}

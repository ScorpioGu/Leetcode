package bfs;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
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

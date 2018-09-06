package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
    	if(s == null || s.length() == 0) 
    		return 0;
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	int max = 0;
    	int j = 0;
    	for(int i=0; i<s.length(); i++) {
    		if(map.containsKey(s.charAt(i))) {
    			 j = Math.max(j,map.get(s.charAt(i))+1);
    		}
    		map.put(s.charAt(i), i);
    		max = Math.max(max, i-j+1);
    	}
    	return max;
    }
}

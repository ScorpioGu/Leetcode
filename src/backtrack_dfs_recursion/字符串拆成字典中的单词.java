package backtrack_dfs_recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/word-break-ii/description/
    Given a non-empty string s and a dictionary wordDict containing a linklist of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

    Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.
    Example 2:

    Input:
    s = "pineapplepenapple"
    wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
    Output:
    [
    "pine apple pen apple",
    "pineapple pen apple",
    "pine applepen apple"
    ]
    Explanation: Note that you are allowed to reuse a dictionary word.
 * @Author gcc
 * @Date 18-11-17 上午10:37
 **/
public class 字符串拆成字典中的单词 {


    /**
     * 使用一个Map来存储每个字符串所能够拆成的字典中的单词组合,则可以避免冗余计算,当遇到已经存在的字符串时,直接去查表就行了
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (wordDict == null || wordDict.size() == 0) {
            return res;
        }
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> res = new ArrayList<>();
        // 这里为空串添加一个“”，下面用于isEmpty判断
        if (s.length() == 0) {
            res.add("");
        }
        for (int i = 1; i <= s.length() ; i++) {
            String word = s.substring(0, i);
            if (wordDict.contains(word)) {
                List<String> list = dfs(s.substring(word.length()), wordDict, map);
                for (String s1 : list) {
                    if (s1.isEmpty()) {
                        res.add(word);
                    } else {
                        res.add(word + " " + s1);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}

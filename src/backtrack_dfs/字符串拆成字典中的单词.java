package backtrack_dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/word-break-ii/description/
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

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
     * 直接使用DFS/backtrack会带来冗余计算问题,同样一个字符串可能会被访问多次
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (wordDict == null || wordDict.size() == 0) {
            return res;
        }

        backTrack(res, new StringBuilder(), s, wordDict, 0);
        return res;
    }

    private void backTrack(List<String> res, StringBuilder sb, String s, List<String> wordDict, int begin) {
        if (begin >= s.length()) {
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
        } else {
            for (int i = begin; i < s.length(); i++) {
                if (wordDict.contains(s.substring(begin, i + 1))) {
                    int start = sb.length();
                    sb.append(s.substring(begin, i + 1) + " ");
                    backTrack(res, sb, s, wordDict, i + 1);
                    sb.delete(start, sb.length());
                }
            }
        }
    }

    /**
     * 使用一个Map来存储每个字符串所能够拆成的字典中的单词组合,则可以避免冗余计算,当遇到已经存在的字符串时,直接去查表就行了
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak2(String s, List<String> wordDict) {
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
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> list = dfs(s.substring(word.length()), wordDict, map);
                for (String ss : list) {
                    if (ss.isEmpty()) {
                        res.add(word);
                    } else {
                        res.add(word + " " + ss);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}

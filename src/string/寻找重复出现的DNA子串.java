package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Desc https://leetcode.com/problems/repeated-dna-sequences/description/
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * @Author gcc
 * @Date 18-11-21 下午5:16
 **/
public class 寻找重复出现的DNA子串 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        if (s == null || s.length() <= 10) {
            return new ArrayList<>();
        }
        for (int i = 0; i < s.length() - 9; i++) {
            String subs = s.substring(i, i + 10);
            //利用set无法重复添加重复元素
            if (!seen.add(subs)) {
                repeated.add(subs);
            }
        }
        return new ArrayList<>(repeated);
    }
}

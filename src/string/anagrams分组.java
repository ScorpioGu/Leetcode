package string;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/group-anagrams/description/
 * 所谓错位词就是包含字符相同但是顺序不同的两个字符串
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * @Author gcc
 * @Date 18-10-22 下午7:23
 **/
public class anagrams分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        //这个一个索引，当匹配到某一个pattern，添加到对应的list
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            //char[]也是可以排序的，这里排序只是将不同字符排列的字符串弄成同一种模式，方便匹配
            //比如abc，acb，bac都整成abc这一种排列。后面遇到cab，cba给他排个序发现也是abc，就找到相应的list把这个字符串添加进去

            //注意pattern的key一定要是String类型而不能是char[]类型的，这是因为String重写了equals方法，只要字符串值相同equals返回true
            //containsKey方法会间接调用对象的equals方法。如果是char[]类型，equals方法依然是Object类的equals方法，这样带来的问题就是
            //key为[a,b,c]，而待加入的字符串对应的排过序的数组对象也是[a.b.c]，但是containsKey返回false，因为两个字符数组引用并不指向同一对象。
            Arrays.sort(cs);
            String pattern = String.valueOf(cs);
            if (map.containsKey(pattern)) {
                map.get(pattern).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(pattern, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}

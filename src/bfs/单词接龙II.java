package bfs;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/word-ladder-ii/description/
 * @Author gcc
 * @Date 18-11-11 下午10:06
 **/
public class 单词接龙II {
    /**
     * TODO
     * 和单词接龙那题题目意思相同,返回值变成了所有可能的路径
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return res;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        //存储每个单词的邻居,即距离为1的单词
        Map<String, Set<String>> neighbors = new HashMap<>();
        //存储每个单词到beginword的最短距离,因为是bfs遍历的,所以可以保证最短距离
        Map<String, Integer> distances = new HashMap<>();
        for (String s : wordSet) {
            neighbors.put(s, new HashSet<>());
        }
        distances.put(beginWord, 0);
        bfs(beginWord, endWord, wordSet, neighbors, distances);
        dfs(res, new ArrayList<>(), beginWord, endWord, neighbors, distances);
        return res;
    }

    /**
     * bfs遍历,填充neighbors,distance
     * @param beginWord
     * @param endWord
     * @param wordSet
     * @param neighbors
     * @param distances
     */
    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> neighbors, Map<String, Integer> distances) {
        boolean done = false;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                //neighbors.put(s, new HashSet<>());
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char pre = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[j] == c) {
                            continue;
                        }
                        chars[j] = c;
                        String ns = String.valueOf(chars);
                        if (wordSet.contains(ns)) {
                            //更新neighbors和distance
                            neighbors.get(s).add(ns);
                            if (!distances.containsKey(ns)) {
                                distances.put(ns, distances.get(s) + 1);
                                //如果遍历到endword了,就没有下一层了,否则还要往队列中加入下一层单词
                                if (endWord.equals(ns)) {
                                    done = true;
                                } else {
                                    queue.offer(ns);
                                }
                            }
                            //已经访问过的单词将不再访问
                        }
                    }
                    chars[j] = pre;
                }
            }
            if (done) {
                break;
            }
        }
    }

    /**
     * dfs遍历,回溯出每条路径保存到结果中
     * @param res
     * @param curList
     * @param curWord
     * @param end
     * @param neighbors
     * @param distances
     */
    private void dfs(List<List<String>> res, List<String> curList, String curWord, String end, Map<String, Set<String>> neighbors, Map<String, Integer> distances) {
        curList.add(curWord);
        if (curWord.equals(end)) {
            res.add(new ArrayList<>(curList));
        } else {
            for (String s : neighbors.get(curWord)) {
                if (distances.get(s) == distances.get(curWord) + 1) {
                    dfs(res, curList, s, end, neighbors, distances);
                }
            }
        }
        curList.remove(curList.size() - 1);
    }
}

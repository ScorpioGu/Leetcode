package design;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements.
 * The probability of each element being returned is linearly related to
 * the number of same value the collection contains.
 *
 * 允许这个这个数据结构中有重复的元素
 * @Author gcc
 * @Date 19-1-13 上午9:32
 **/
public class 插入删除随机访问元素II {
    private List<Integer> list;
    //LinkedHashSet保证了遍历元素的有序性,在HashSet的基础上为每个节点加了before,after指针
    private Map<Integer, Set<Integer>> map;
    private Random rand;
    /** Initialize your data structure here. */
    public 插入删除随机访问元素II() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        //用map来判断,使用list判断的话时间复杂度不是o(1)
        boolean contain = map.containsKey(val);
        list.add(val);
        //如果之前没有过,需要新建一个
        if (!contain) {
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(list.size() - 1);
        return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            return false;
        }
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (index < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.get(last).remove(list.size()-1);
            map.get(last).add(index);
        }
        list.remove(list.size() - 1);

        //如果某一重复元素删完了,将其从map中移除
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

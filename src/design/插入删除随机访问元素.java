package design;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/insert-delete-getrandom-o1/
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * @Author gcc
 * @Date 19-1-12 下午10:43
 **/
public class 插入删除随机访问元素 {
    /**
     * 存储数
     * ArrayList插入的时间复杂度为o(1),删除的时间复杂度为o(1)
     */
    private List<Integer> nums;
    /**
     * 存储数对应的在nums中的下标
     * map的存储和删除的时间复杂度为o(1),但是不能随机访问元素
     */
    private Map<Integer, Integer> map;

    private Random rand;
    /** Initialize your data structure here. */
    public 插入删除随机访问元素() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (nums.contains(val)) {
            return false;
        }
        nums.add(val);
        map.put(val, nums.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!nums.contains(val)) {
            return false;
        }
        int index = map.get(val);
        if (index < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            map.put(last, index);
        }
        nums.remove(nums.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        //nextInt(i) 返回[0, i)内的随机数
        return nums.get(rand.nextInt(nums.size()));
    }
}

package findByIndex;

/**
 * @Desc https://leetcode.com/problems/find-the-duplicate-number/
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 *
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * @Author gcc
 * @Date 18-12-14 上午11:15
 **/
public class 寻找唯一重复的元素 {

    /**
     * 想到链表成环那题,把这个数组也当做一个链表,很好的地方在于
     * 数组中的值不会超过数组的长度,那么我可以认为数组中的值存放的是下一个节点的坐标
     * 这样就形成了一个链表,那么举例来说 3,1,3,4,2
     * 其遍历顺序是3, 4, 2, 3, 4, 2....
     * 第0跳是nums[0],第二跳是nums[1],..
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //slow停在第一个节点
        int slow = nums[0];
        //fast停在第二个节点
        int fast = nums[nums[0]];

        //此时fast,slow已经迈出了第一(二)步了,为了满足初始情况slow != fast的条件
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //fast停在第0个节点
        fast = 0;
        while(fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

    }
}

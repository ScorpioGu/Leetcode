package design;

/**
 * @Desc https://leetcode.com/problems/range-sum-query-mutable/
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 *
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 * 因为现在有更新操作了，所以按原来的做法，更新一个数需要更新数组，时间负责度是ｏ(n)
 * 而线段树（segment tree）和树状数组(binary indexed tree)的插入与修改的时间复杂度都为o(lgn)
 * @Author gcc
 * @Date 18-12-19 下午5:50
 **/
public class 求可变数组指定区间的元素和 {
    private class SegmentTreeNode {
        int left;
        int right;
        int sum;
        SegmentTreeNode leftChild;
        SegmentTreeNode rightChild;

        public SegmentTreeNode(int left, int right) {
            this.left = left;
            this.right = right;
            this.leftChild = null;
            this.rightChild = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root;
    public 求可变数组指定区间的元素和(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode cur = new SegmentTreeNode(start, end);
            if (start == end) {
                cur.sum = nums[start];
            } else {
                cur.leftChild = buildTree(nums, start, start + (end - start) / 2);
                cur.rightChild = buildTree(nums, start + (end - start) / 2 + 1, end);
                cur.sum = cur.leftChild.sum + cur.rightChild.sum;
            }
            return cur;
        }
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode cur, int i, int val) {
        if (cur.left == cur.right) {
            //找到这个叶子节点了,更新它
            cur.sum = val;
        } else {
            int mid = cur.left + (cur.right - cur.left)/2;
            if (i <= mid) {
                update(cur.leftChild, i, val);
            } else {
                update(cur.rightChild, i, val);
            }
            cur.sum = cur.leftChild.sum + cur.rightChild.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode cur, int start, int end) {
        //刚好区间对应上了当前节点的区间,那么直接返回它的sum
        if (cur.left == start && cur.right == end) {
            return cur.sum;
        }
        int mid = cur.left + (cur.right - cur.left)/2;
        if (end <= mid) {
            return sumRange(cur.leftChild, start, end);
        }
        if (start > mid) {
            return sumRange(cur.rightChild, start, end);
        }
        return sumRange(cur.leftChild, start, mid) + sumRange(cur.rightChild, mid + 1, end);
    }



/*  树状数组
    int[] nums;
    //bit[i]包含了nums[i-1]
    int[] bit;
    public 求可变数组指定区间的元素和(int[] nums) {
        this.nums = nums;
        int len = nums.length;
        bit = new int[len + 1];
        for (int i = 0; i < len; i++) {
            init(i, nums[i]);
        }
    }

    //对i处元素进行修改,所有包含了该元素的位置也要更着修改
    public void init(int i, int val) {
        i++;
        while (i < bit.length) {
            bit[i] += val;
            //i & -1是求i里第一个i所在的位, 之后i变成了下一个需要修改的位置
            i += (i & -i);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    int getSum(int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= (i &- i);
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        //因为要包括nums[i],所有后面这项是getSum(i-1)
        return getSum(j) - getSum(i-1);
    }*/
}

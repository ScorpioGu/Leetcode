package design;

import support.ListNode;

import java.util.Random;

/**
 * @Desc https://leetcode.com/problems/linked-linklist-random-node/
 * Given a singly linked linklist, return a random node's value from the linked linklist. Each node must have the same probability of being chosen.
 *
 * Follow up:
 * What if the linked linklist is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 *
 * 蓄水池抽样算法解决的是这样一个问题,有一个数据流很大,大小也不知道.但是让你去随机取其中的元素,兵器保证概率相同
 * 如果我们直到数据流有多大,产生一个该范围的随机数就可以做,不清楚总的数据个数,又要求等概率,这就有点难办
 *
 * 蓄水池抽样算法,假设数据量为n(未知),对于第m个元素,选择它的概率是1/m.从一个元素往后遍历,都会去判断这个元素要不要选取
 * 因为要求返回其中一个元素,所以后面选取的元素将覆盖之前选择的.因为最终任意一个元素m返回的概率 = 选择m的概率 * (后面m+1到n都不选的概率)
 * =1/m * (m/m+1 * m+1/m+2 * m+2/m+3....n-1/n)=1/n
 * 那么每个元素选择的概率是相同的1/n
 * 为什么不要求0到m-1都不选,因为选不选无所谓,只要m选了,可以覆盖前面的.
 *
 * @Author gcc
 * @Date 19-1-13 上午10:04
 **/
public class 蓄水池抽样算法 {
    ListNode head;
    Random rand;
    /** @param head The linked linklist's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public 蓄水池抽样算法(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = head.val;
        ListNode cur = head.next;
        int k = 1;
        while (cur != null) {
            k++;
            if (rand.nextInt(k) == k-1) {
                res = cur.val;
            }
            cur = cur.next;
        }
        return res;
    }
}

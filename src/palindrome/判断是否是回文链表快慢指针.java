package palindrome;

import linklist.逆转链表;
import support.ListNode;

public class 判断是否是回文链表快慢指针 {
    public boolean isPalindrome(ListNode head) {
    	if(head == null || head.next == null) 
    		return true;
    	//快慢指针，fast跑带链表尾，slow跑到链表中间。
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        //将链表后半部分逆转，随后前半部分比较是否相同
        if(fast == null) {
            //链表长度为偶数
        	slow = new 逆转链表().reverseList(slow);
        } else {
            //链表长度为奇数
        	slow = new 逆转链表().reverseList(slow.next);
        }
        while(slow != null) {
        	if(slow.val != head.val) {
        		return false;
        	}
        	slow = slow.next;
        	head = head.next;
        }
        return true;
    }
}


package list;

import support.ListNode;
import support.ReverseLinkedList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
    	if(head == null || head.next == null) 
    		return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        if(fast == null) { //链表长度为偶数
        	slow = ReverseLinkedList.reverseList(slow);
        } else { //链表长度为奇数
        	slow = ReverseLinkedList.reverseList(slow.next);
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


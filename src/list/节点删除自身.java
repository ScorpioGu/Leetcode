package list;


import support.ListNode;

//节点删除自身
//节点时没法访问前一个节点的，所以删除自身就是复制下一个节点的值，然后删除下一个节点
public class 节点删除自身 {
    public void deleteNode(ListNode node) {
    	if(node == null) return;
    	if(node.next != null) {
        	node.val = node.next.val;
        	node.next = node.next.next;
    	}
    }
}

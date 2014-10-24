/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
/**
 *
 *  * Definition for singly-linked list.
 *
 *  * class ListNode {
 *
 *  *     int val;
 *
 *  *     ListNode next;
 *
 *  *     ListNode(int x) {
 *
 *  *         val = x;
 *
 *  *         next = null;
 *
 *  *     }
 *
 *  * }
 *
 **/
public class Solution {
    public void reorderList(ListNode head) {
	ListNode slow=head,fast=head;
	if(fast==null||fast.next==null){
	    return;
	}
	fast=fast.next.next;
	while(fast!=null&&fast.next!=null){
	    slow=slow.next;
	    fast=fast.next.next;
	}
	ListNode right=reverse(slow.next);
	slow.next=null;
	merge(head,right);
    }
    private ListNode reverse(ListNode head){
	ListNode pre=null,cur=head,next;
	while(cur!=null){
	    next=cur.next;
	    cur.next=pre;
	    pre=cur;
	    cur=next;
	}
	return pre;
    }
    private void merge(ListNode left,ListNode right){
	boolean flag=true;
	ListNode p=left;
	left=left.next;
	while(left!=null&&right!=null){
	    if(flag){
		p.next=right;
		right=right.next;
	    }else{
		p.next=left;
		left=left.next;
	    }
	    p=p.next;
	    flag=!flag;
	}   
	if(left!=null){
	    p.next=left;
	}
	if(right!=null){
	    p.next=right;
	}
    }
}

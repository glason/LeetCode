/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
/**
 *
 *  * Definition for singly-linked list.
 *
 *   * public class ListNode {
 *
 *    *     int val;
 *
 *     *     ListNode next;
 *
 *      *     ListNode(int x) {
 *
 *       *         val = x;
 *
 *        *         next = null;
 *
 *         *     }
 *
 *          * }
 *
 *           */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
	ListNode dummy=new ListNode(0);
	dummy.next=head;
	ListNode p=head,pre=dummy;
	while(p!=null){
	    if(p.next!=null&&p.val==p.next.val){
		while(p.next!=null&&p.val==p.next.val){
		    p=p.next;
		}
		pre.next=p.next;
		p.next=null;
		p=pre.next;
	    }else{
		pre=p;
		p=p.next;
	    }
	}
	return dummy.next;
    }
}

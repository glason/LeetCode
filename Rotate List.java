/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int n) {
	if(head==null){
	    return null;
	}
	ListNode l=head,r=null;;
	for(int i=n;i>0;i--){
	    if(r==null){
		r=head;
	    }
	    r=r.next;
	}
	if(r==null){
	    return head;
	}
	while(r.next!=null){
	    l=l.next;
	    r=r.next;
	}
	ListNode result=l.next;
	l.next=null;
	r.next=head;
	return result;
    }
}

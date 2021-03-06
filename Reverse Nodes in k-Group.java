/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
	ListNode cur=head;
	for(int i=1;i<k&&cur!=null;i++){
	    cur=cur.next;
	}
	if(cur==null){
	    return head;
	}
	ListNode nhead=reverseKGroup(cur.next,k);
	cur.next=null;
	reverse(head);
	head.next=nhead;
	return cur;
    }
    private void reverse(ListNode head){
	ListNode pre=null,cur=head,next;
	while(cur!=null){
	    next=cur.next;
	    cur.next=pre;
	    pre=cur;
	    cur=next;
	}
    }
}

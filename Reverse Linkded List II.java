/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
	int i=1;
	ListNode pre=null,cur=head,next=null,left=null;
	while(cur!=null){
	    next=cur.next;
	    if(i==m){
		left=pre;       
	    }else if(i==n){
		cur.next=pre;
		if(left!=null){
		    left.next.next=next;
		    left.next=cur;
		}else{
		    head.next=next;
		    head=cur;
		}   
		break;
	    }else if(i>m&&i<n){
		cur.next=pre;
	    }
	    pre=cur;
	    cur=next;
	    i++;
	}
	return head;
    }
}

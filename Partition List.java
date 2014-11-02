/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
/**
 *
 *  * Definition for singly-linked list.
 *
 *   * public class ListNode {
 *
 *   *     int val;
 *
 *   *     ListNode next;
 *
 *   *     ListNode(int x) {
 *
 *   *         val = x;
 *
 *   *         next = null;
 *
 *   *     }
 *
 *   * }
 *
 **/
public class Solution {
    public ListNode partition(ListNode head, int x) {
	ListNode less=new ListNode(0);
	ListNode great=new ListNode(0);
	ListNode l=less,g=great,p=head;
	while(p!=null){
	    if(p.val<x){
		l.next=p;
		l=l.next;
	    }else{
		g.next=p;
		g=g.next;
	    }
	    p=p.next;
	}
	g.next=null;
	l.next=great.next;
	return less.next;
    }
}

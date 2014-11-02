/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
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
 *   */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
	ListNode p=head;
	ListNode pre=null;
	while(p!=null){
	    if(pre!=null&&p.val==pre.val){
		pre.next=p.next;
		p.next=null;
		p=pre.next;
	    }else{
		pre=p;
		p=p.next;
	    }
	}
	return head;
    }
}

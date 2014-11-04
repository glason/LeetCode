/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
 *  */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	ListNode dummy=new ListNode(0);
	ListNode cur=dummy,p=l1,q=l2;
	while(p!=null&&q!=null){
	    if(p.val<q.val){
		cur.next=p;
		cur=p;
		p=p.next;
	    }else{
		cur.next=q;
		cur=q;
		q=q.next;
	    }
	}
	while(p!=null){
	    cur.next=p;
	    cur=p;
	    p=p.next;
	}
	while(q!=null){
	    cur.next=q;
	    cur=q;
	    q=q.next;
	}
	return dummy.next;
    }
}

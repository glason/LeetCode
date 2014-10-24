/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
/**
 *
 *  * Definition for singly-linked list.
 *
 *   * class ListNode {
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
    public ListNode sortList(ListNode head) {
	ListNode one=head,two=head;
	if(two==null||two.next==null){
	    return head;
	}
	two=two.next.next;
	while(two!=null&&two.next!=null){
	    one=one.next;
	    two=two.next.next;
	}
	ListNode right=sortList(one.next);
	one.next=null;
	ListNode left=sortList(head);
	return merge(left,right);
    }
    private ListNode merge(ListNode left,ListNode right){
	ListNode head=null,cur=null;
	while(left!=null&&right!=null){
	    ListNode next=null;
	    if(left.val<right.val){
		next=left;
		left=left.next;
	    }else{
		next=right;
		right=right.next;
	    }
	    if(head==null){
		head=next;
		cur=head;
	    }else{
		cur.next=next;
		cur=next;
	    }
	}
	if(left!=null){
	    cur.next=left;
	}
	if(right!=null){
	    cur.next=right;
	}
	return head;
    }
}

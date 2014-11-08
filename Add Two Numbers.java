/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode dummy=new ListNode(0),cur=dummy;
	int carry=0;
	while(l1!=null||l2!=null){
	    if(l1!=null){
		carry+=l1.val;
		l1=l1.next;
	    }
	    if(l2!=null){
		carry+=l2.val;
		l2=l2.next;
	    }
	    cur.next=new ListNode(carry%10);
	    carry/=10;
	    cur=cur.next;
	}
	if(carry!=0){
	    cur.next=new ListNode(carry);
	}
	return dummy.next;
    }
}

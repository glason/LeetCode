/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists(List<ListNode> lists) {
	if(lists.size()==0){
	    return null;
	}
	return merge(lists,0,lists.size()-1);        
    }
    private ListNode merge(List<ListNode> l,int s,int e){
	if(s==e){
	    return l.get(s);
	}
	int m=(s+e)/2;
	ListNode dummy=new ListNode(0),pre=dummy;
	ListNode left=merge(l,s,m);
	ListNode right=merge(l,m+1,e);
	while(left!=null&&right!=null){
	    if(left.val<right.val){
		pre.next=left;
		left=left.next;
	    }else{
		pre.next=right;
		right=right.next;
	    }
	    pre=pre.next;
	}
	while(left!=null){
	    pre.next=left;
	    left=left.next;
	    pre=pre.next;
	}
	while(right!=null){
	    pre.next=right;
	    right=right.next;
	    pre=pre.next;
	}
	return dummy.next;
    }
}

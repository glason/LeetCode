/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
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
 *      *     ListNode(int x) { val = x; next = null; }
 *
 *       * }
 *
 *        */
/**
 *
 *  * Definition for binary tree
 *
 *   * public class TreeNode {
 *
 *    *     int val;
 *
 *     *     TreeNode left;
 *
 *      *     TreeNode right;
 *
 *       *     TreeNode(int x) { val = x; }
 *
 *        * }
 *
 *         */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
	if(head==null){
	    return null;
	}
	ListNode slow=head,fast=head;
	if(fast!=null&&fast.next!=null){
	    fast=fast.next.next;
	}
	while(fast!=null&&fast.next!=null){
	    slow=slow.next;
	    fast=fast.next.next;
	}
	if(slow.next==null){
	    return new TreeNode(slow.val);
	}
	TreeNode root=new TreeNode(slow.next.val);
	TreeNode right=sortedListToBST(slow.next.next);
	slow.next=null;
	TreeNode left=sortedListToBST(head);
	root.left=left;
	root.right=right;
	return root;
    }
}

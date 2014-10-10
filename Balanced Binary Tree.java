/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
/**
 *
 *  * Definition for binary tree
 *  * public class TreeNode {
 *  *     int val;
 *  *     TreeNode left;
 *  *     TreeNode right;
 *  *     TreeNode(int x) { val = x; }
 *  * }
 **/
public class Solution {
    List<Integer> diff;
    public boolean isBalanced(TreeNode root) {
	if(root==null){
	    return true;
	}
	diff = new ArrayList<Integer>();
	calcHeight(root);
	for(Integer i:diff){
	    if(Math.abs(i)>1){
		return false;
	    }
	}
	return true;
    }
    public int calcHeight(TreeNode root){
	if(root==null){
	    return 0;
	}
	int left=calcHeight(root.left);
	int right=calcHeight(root.right);
	diff.add(left-right);
	return Math.max(left,right)+1;
    }
}

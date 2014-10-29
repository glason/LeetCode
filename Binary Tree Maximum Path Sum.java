/**
 * Given a binary tree, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 *
 * For example:
 * Given the below binary tree,
 *
 *        1
 *       / \
 *      2   3
 * Return 6.
 */
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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
	max(root);
	return max;
    }
    private int max(TreeNode root){
	if(root==null){
	    return 0;
	}
	int left=Math.max(0,max(root.left));
	int right=Math.max(0,max(root.right));
	max=Math.max(max,left+right+root.val);
	return Math.max(left,right)+root.val;
    }
}

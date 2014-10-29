/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    int depth;
    public int minDepth(TreeNode root) {
	if(root==null){
	    return 0;
	}
	depth=Integer.MAX_VALUE;
	dfs(root,1);
	return depth;
    }
    private void dfs(TreeNode node,int d){
	if(node==null){
	    return;
	}
	if(node.left==null&&node.right==null){
	    depth=Math.min(depth,d);
	}else{
	    dfs(node.left,d+1);
	    dfs(node.right,d+1);
	}
    }
}

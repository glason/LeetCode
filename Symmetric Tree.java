/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
	if(root==null){
	    return true;
	}
	return dfs(root.left,root.right);
    }
    private boolean dfs(TreeNode l,TreeNode r){
	if(l==null&&r==null){
	    return true;
	}else if(l==null||r==null){
	    return false;
	}else if(l.val==r.val){
	    return dfs(l.left,r.right)&&dfs(l.right,r.left);
	}else{
	    return false;
	}
    }
}
public class Solution {
    public boolean isSymmetric(TreeNode root) {
	if(root==null||(root.left==null&&root.right==null)){
	    return true;
	}
	if(!isEqual(root.left,root.right)){
	    return false;
	}
	Queue<TreeNode> left=new LinkedList<>();
	Queue<TreeNode> right=new LinkedList<>();
	left.offer(root.left);
	right.offer(root.right);
	while(!left.isEmpty()&&!right.isEmpty()){
	    TreeNode lnode=left.poll();
	    TreeNode rnode=right.poll();
	    if(!isEqual(lnode.left,rnode.right)){
		return false;
	    }
	    if(!isEqual(lnode.right,rnode.left)){
		return false;
	    }
	    if(lnode.left!=null){
		left.offer(lnode.left);
		right.offer(rnode.right);
	    }
	    if(lnode.right!=null){
		left.offer(lnode.right);
		right.offer(rnode.left);
	    }
	}
	if(!left.isEmpty()||!right.isEmpty()){
	    return false;
	}
	return true;
    }
    private boolean isEqual(TreeNode l,TreeNode r){
	if(l==null&&r==null){
	    return true;
	}else if(l==null||r==null){
	    return false;
	}else{
	    return l.val==r.val;
	}
    }
}

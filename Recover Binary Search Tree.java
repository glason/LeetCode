/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
    public void recoverTree(TreeNode root) {
	TreeNode pre=null,p=null,l=null,r=null;
	Stack<TreeNode> stack=new Stack<>();
	p=root;
	while(p!=null||!stack.isEmpty()){
	    while(p!=null){
		stack.push(p);
		p=p.left;
	    }
	    p=stack.pop();
	    if(pre!=null){
		if(p.val<pre.val){
		    if(l==null){
			l=pre;
			r=p;
		    }else{
			r=p;
		    }
		}
	    }
	    pre=p;
	    p=p.right;
	}
	if(l!=null&&r!=null){
	    int tmp=l.val;
	    l.val=r.val;
	    r.val=tmp;
	}
    }
}

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 *   return [1,3,2].
 *
 *   Note: Recursive solution is trivial, could you do it iteratively?
 *
 *
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
    public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> result=new ArrayList<>();
	Stack<TreeNode> stack=new Stack<>();
	TreeNode p=root;
	while(p!=null||!stack.isEmpty()){
	    while(p!=null){
		stack.push(p);
		p=p.left;
	    }
	    p=stack.pop();
	    result.add(p.val);
	    p=p.right;
	}
	return result;
    }
}

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 *return [1,2,3].
 *
 *Note: Recursive solution is trivial, could you do it iteratively?
 */
/**
 *
 *  * Definition for binary tree
 *
 *  * public class TreeNode {
 *
 *  *     int val;
 *
 *  *     TreeNode left;
 *
 *  *     TreeNode right;
 *
 *  *     TreeNode(int x) { val = x; }
 *
 *  * }
 *
 * */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
	List<Integer> result=new ArrayList<>();
	TreeNode p=root;
	Stack<TreeNode> stack=new Stack<TreeNode>();
	while(p!=null||!stack.isEmpty()){
	    while(p!=null){
		result.add(p.val);
		stack.push(p);
		p=p.left;
	    }
	    p=stack.pop();
	    p=p.right;
	}
	return result;
    }
}

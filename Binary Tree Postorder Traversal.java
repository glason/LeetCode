/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
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
 **/
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
	List<Integer> result=new ArrayList<>();
	Stack<TreeNode> stack=new Stack<>();
	Stack<Boolean> flag=new Stack<>();
	TreeNode p=root;
	while(p!=null||!stack.isEmpty()){
	    while(p!=null){
		stack.push(p);
		flag.push(false);
		p=p.left;
	    }
	    p=stack.pop();
	    boolean b=flag.pop();
	    if(b){
		result.add(p.val);
		p=null;
	    }else{
		stack.push(p);
		flag.push(true);
		p=p.right;
	    }
	}
	return result;
    }
}

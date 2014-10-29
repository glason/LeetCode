/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 *   The flattened tree should look like:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
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
    public void flatten(TreeNode root) {
	Stack<TreeNode> stack=new Stack<>();
	List<TreeNode> result=new ArrayList<>();
	TreeNode p=root;
	while(p!=null||!stack.isEmpty()){
	    while(p!=null){
		result.add(p);
		stack.push(p);
		p=p.left;
	    }
	    p=stack.pop();
	    p=p.right;
	}
	p=null;
	for(TreeNode node:result){
	    if(p!=null){
		p.left=null;
		p.right=node;
	    }
	    p=node;
	}
    }
}

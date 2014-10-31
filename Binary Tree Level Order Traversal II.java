/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *return its bottom-up level order traversal as:
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	List<List<Integer>> result=new LinkedList<>();
	if(root==null){
	    return result;
	}
	Queue<TreeNode> queue=new LinkedList<>();
	queue.offer(root);
	TreeNode SEP=new TreeNode(0);
	queue.offer(SEP);
	List<Integer> solution=new ArrayList<>();
	while(!queue.isEmpty()){
	    TreeNode node=queue.poll();
	    if(node==SEP){
		result.add(0,new ArrayList<Integer>(solution));
		solution.clear();
		if(!queue.isEmpty()){
		    queue.offer(SEP);
		}
	    }else{
		solution.add(node.val);
		if(node.left!=null){
		    queue.offer(node.left);
		}
		if(node.right!=null){
		    queue.offer(node.right);
		}
	    }
	}
	return result;
    }
}

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 *  [
 *   [3],
 *   [9,20],
 *   [15,7]
 *  ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> result=new ArrayList<>();
	if(root==null){
	    return result;
	}
	List<Integer> solution=new ArrayList<>();
	Queue<TreeNode> queue=new LinkedList<>();
	queue.offer(root);
	TreeNode SEP=new TreeNode(0);
	queue.offer(SEP);
	while(!queue.isEmpty()){
	    TreeNode node=queue.poll();
	    if(node==SEP){
		result.add(new ArrayList<Integer>(solution));
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

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	List<List<Integer>> result=new ArrayList<>();
	dfs(result,new ArrayList<Integer>(),root,sum);
	return result;
    }
    private void dfs(List<List<Integer>> result,List<Integer> solution,TreeNode root,int sum){
	if(root==null){
	    return;
	}
	solution.add(root.val);
	if(root.val==sum&&root.left==null&&root.right==null){
	    result.add(new ArrayList<Integer>(solution));
	}else{
	    dfs(result,solution,root.left,sum-root.val);
	    dfs(result,solution,root.right,sum-root.val);
	}
	solution.remove(solution.size()-1);
    }
}

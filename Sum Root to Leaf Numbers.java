/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * For example,
 *
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = 12 + 13 = 25.
 */
/**
 *
 *  * Definition for binary tree
 *
 *   * public class TreeNode {
 *
 *   *     int val;
 *
 *   *     TreeNode left;
 *
 *   *     TreeNode right;
 *
 *   *     TreeNode(int x) { val = x; }
 *
 *   * }
 *
 *         */
public class Solution {
    public int sumNumbers(TreeNode root) {
	List<Integer> result=new ArrayList<>();
	dfs(result,0,root);
	int sum=0;
	for(int i:result){
	    sum+=i;
	}
	return sum;
    }
    private void dfs(List<Integer> result,int prefix,TreeNode root){
	if(root==null){
	    return;
	}
	if(root.left==null&&root.right==null){
	    result.add(10*prefix+root.val);
	    return;
	}
	if(root.left!=null){
	    dfs(result,10*prefix+root.val,root.left);
	}
	if(root.right!=null){
	    dfs(result,10*prefix+root.val,root.right);
	}
    }
}

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
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
 *       *     TreeNode(int x) { val = x; left = null; right = null; }
 *
 *        * }
 *
 *         */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
	return dfs(1,n);       
    }
    private List<TreeNode> dfs(int s,int e){
	List<TreeNode> result=new ArrayList<>();
	if(s>e){
	    result.add(null);
	}
	for(int i=s;i<=e;i++){
	    result.addAll(getList(i,dfs(s,i-1),dfs(i+1,e)));   
	}
	return result;
    }
    private List<TreeNode> getList(int val,List<TreeNode> left,List<TreeNode> right){
	List<TreeNode> result=new ArrayList<>();
	for(TreeNode l:left){
	    for(TreeNode r:right){
		TreeNode node=new TreeNode(val);
		node.left=l;
		node.right=r;
		result.add(node);
	    }
	}
	return result;        
    }
}

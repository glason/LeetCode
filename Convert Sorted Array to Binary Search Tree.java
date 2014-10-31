/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] num) {
	return dfs(num,0,num.length-1);
    }
    private TreeNode dfs(int[] num,int start,int end){
	if(start>end){
	    return null;
	}else if(start==end){
	    return new TreeNode(num[start]);
	}
	int mid=(start+end)/2;
	TreeNode root=new TreeNode(num[mid]);
	root.left=dfs(num,start,mid-1);
	root.right=dfs(num,mid+1,end);
	return root;
    }
}

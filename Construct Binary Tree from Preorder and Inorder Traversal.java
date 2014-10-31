/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
	return dfs(preorder,0,inorder,0,preorder.length);    
    }
    private TreeNode dfs(int[] pre,int ps,int[] in,int is,int len){
	if(len==0){
	    return null;
	}
	TreeNode root=new TreeNode(pre[ps]);
	int leftLen=0;
	while(in[is+leftLen]!=root.val){
	    leftLen++;
	}
	root.left=dfs(pre,ps+1,in,is,leftLen);
	root.right=dfs(pre,ps+leftLen+1,in,is+leftLen+1,len-leftLen-1);
	return root;
    }
}

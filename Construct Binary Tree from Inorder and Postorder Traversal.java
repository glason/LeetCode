/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
	int len=inorder.length;
	if(len==0){
	    return null;
	}
	int val=postorder[len-1];
	TreeNode root=new TreeNode(val);
	if(len==1){
	    return root;
	}
	int llen=0;
	for(int i=0;i<len;i++){
	    if(inorder[i]==val){
		llen=i;
		break;
	    }
	}
	int[] lin=new int[llen];
	int[] lpost=new int[llen];
	int[] rin=new int[len-llen-1];
	int[] rpost=new int[len-llen-1];
	for(int i=0;i<llen;i++){
	    lin[i]=inorder[i];
	    lpost[i]=postorder[i];
	}
	for(int i=0;i<len-llen-1;i++){
	    rin[i]=inorder[llen+i+1];
	    rpost[i]=postorder[llen+i];
	}
	root.left=buildTree(lin,lpost);
	root.right=buildTree(rin,rpost);
	return root;
    }
}

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	boolean leftToRight = true;
	List<TreeNode> level=new ArrayList<>();
	List<TreeNode> nextLevel = new ArrayList<>();
	level.add(root);
	while(true){
	    List<Integer> list = new ArrayList<Integer>();
	    if(leftToRight){
		for(TreeNode t:level){
		    if(t!=null){
			list.add(t.val);  
		    }
		}
	    }else{
		for(int i=level.size()-1;i>=0;i--){
		    TreeNode node = level.get(i);
		    if(node!=null){
			list.add(node.val);
		    }
		}
	    }
	    if(list.size()==0){
		break;
	    }
	    result.add(list);
	    leftToRight=!leftToRight;
	    for(TreeNode t:level){
		if(t!=null){
		    nextLevel.add(t.left);
		    nextLevel.add(t.right);
		}
	    }
	    level.clear();
	    level.addAll(nextLevel);
	    nextLevel.clear();
	}
	return result;
    }
}

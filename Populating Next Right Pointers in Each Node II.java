/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 *
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *         1 -> NULL
 *       /  \
 *      2 -> 3 -> NULL
 *     / \    \
 *    4-> 5 -> 7 -> NULL
 */
/**
 *
 *  * Definition for binary tree with next pointer.
 *
 *   * public class TreeLinkNode {
 *
 *    *     int val;
 *
 *     *     TreeLinkNode left, right, next;
 *
 *      *     TreeLinkNode(int x) { val = x; }
 *
 *       * }
 *
 *        */
public class Solution {
    public void connect(TreeLinkNode root) {
	if(root==null){
	    return;
	}    
	TreeLinkNode SEP=new TreeLinkNode(0),pre=SEP;
	Queue<TreeLinkNode> queue=new LinkedList<>();
	queue.offer(root);
	queue.offer(SEP);
	while(!queue.isEmpty()){
	    TreeLinkNode node=queue.poll();
	    if(node==SEP){
		pre.next=null;
		if(!queue.isEmpty()){
		    queue.offer(SEP);
		}
	    }else{
		pre.next=node;
		if(node.left!=null){
		    queue.offer(node.left);
		}
		if(node.right!=null){
		    queue.offer(node.right);
		}
	    }
	    pre=node;
	}
    }
}

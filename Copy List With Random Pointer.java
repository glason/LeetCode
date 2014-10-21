/**
*A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

*Return a deep copy of the list.
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur=head;
        while(cur!=null){
            RandomListNode node=new RandomListNode(cur.label);
            RandomListNode next=cur.next;
            cur.next=node;
            node.next=next;
            cur=next;
        }
        cur=head;
        while(cur!=null){
            RandomListNode next=cur.next;
            next.random=cur.random==null?null:cur.random.next;
            cur=next.next;
        }
        RandomListNode nhead=null,p=head,np=null;
        cur=head;
        while(cur!=null){
            if(nhead==null){
                nhead=cur.next;
                np=nhead;
                cur=cur.next.next;
            }else{
                p.next=cur;
                p=p.next;
                cur=cur.next;
                
                np.next=cur;
                np=np.next;
                cur=cur.next;
            }    
        }
        if(p!=null){
            p.next=null;
        }
        return nhead;
    }
}

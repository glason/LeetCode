/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class Solution {
    public int minCut(String s) {
	int len=s.length();
	boolean[][] palindrome=new boolean[len][len];
	int[] mincut=new int[len+1];
	for(int i=len-1;i>=0;i--){
	    mincut[i]=len-i;
	    for(int j=i;j<len;j++){
		if(s.charAt(j)==s.charAt(i)){
		    if(j-i<=2||palindrome[i+1][j-1]){
			palindrome[i][j]=true;
			mincut[i]=Math.min(mincut[i],1+mincut[j+1]);
		    }
		}    
	    }
	}
	return mincut[0]-1;
    }
}

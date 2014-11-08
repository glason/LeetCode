/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class Solution {
    public String longestPalindrome(String s) {
	int len=s.length();
	boolean[][] dp=new boolean[len][len];
	int start=0,end=0;
	for(int i=len-1;i>=0;i--){
	    for(int j=i;j<len;j++){
		if(j-i<=1||dp[i+1][j-1]){
		    dp[i][j]=s.charAt(i)==s.charAt(j);
		    if(dp[i][j]&&end-start<j-i){
			start=i;
			end=j;
		    }
		}
	    }
	}
	return s.substring(start,end+1);
    }
}

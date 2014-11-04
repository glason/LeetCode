/**
 * Unique Paths Total Accepted: 24312 Total Submissions: 76610 My Submissions Question Solution 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 */
public class Solution {
    public int uniquePaths(int m, int n) {
	if(m*n==0){
	    return 0;
	}   
	int[][] dp=new int[m][n];
	for(int i=0;i<m;i++){
	    dp[i][n-1]=1;
	}
	for(int j=0;j<n;j++){
	    dp[m-1][j]=1;
	}
	for(int i=m-2;i>=0;i--){
	    for(int j=n-2;j>=0;j--){
		dp[i][j]=dp[i+1][j]+dp[i][j+1];
	    }
	}
	return dp[0][0];
    }
}

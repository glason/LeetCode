/**
 * ollow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 *   [0,0,0],
 *     [0,1,0],
 *       [0,0,0]
 *       ]
 *       The total number of unique paths is 2.
 *
 *       Note: m and n will be at most 100.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	int m=obstacleGrid.length;
	int n=obstacleGrid[0].length;
	if(obstacleGrid[m-1][n-1]==1){
	    return 0;
	}
	int[][] dp=new int[m][n];
	dp[m-1][n-1]=1;
	for(int i=m-2;i>=0;i--){
	    if(obstacleGrid[i][n-1]==1){
		dp[i][n-1]=0;
	    }else{
		dp[i][n-1]=dp[i+1][n-1];
	    }
	}
	for(int j=n-2;j>=0;j--){
	    if(obstacleGrid[m-1][j]==1){
		dp[m-1][j]=0;
	    }else{
		dp[m-1][j]=dp[m-1][j+1];
	    }
	}
	for(int i=m-2;i>=0;i--){
	    for(int j=n-2;j>=0;j--){
		if(obstacleGrid[i][j]==1){
		    dp[i][j]=0;
		}else{
		    dp[i][j]=dp[i+1][j]+dp[i][j+1];
		}
	    }
	}
	return dp[0][0];
    }
}

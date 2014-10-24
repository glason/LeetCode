/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 *
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Solution {
    public int[][] generateMatrix(int n) {
	int num=1;
	int[][] result=new int[n][n];
	for(int level=0;level<(n+1)/2;level++){
	    if(level==n-level-1){
		result[level][level]=num++;
		continue;
	    }
	    for(int i=level;i<n-level-1;i++){
		result[level][i]=num++;   
	    }
	    for(int i=level;i<n-level-1;i++){
		result[i][n-level-1]=num++;
	    }
	    for(int i=n-level-1;i>level;i--){
		result[n-level-1][i]=num++;
	    }
	    for(int i=n-level-1;i>level;i--){
		result[i][level]=num++;
	    }
	}
	return result;
    }
}

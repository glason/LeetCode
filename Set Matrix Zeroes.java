/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 * click to show follow up.
 *
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
	int m=matrix.length;
	int n=m==0?0:matrix[0].length;
	if(m*n==0){
	    return;
	}
	boolean[] row=new boolean[m];
	boolean[] col=new boolean[n];
	for(int i=0;i<m;i++){
	    for(int j=0;j<n;j++){
		if(matrix[i][j]==0){
		    row[i]=true;
		    col[j]=true;
		}
	    }
	}
	for(int i=0;i<m;i++){
	    for(int j=0;j<n;j++){
		if(row[i]|col[j]){
		    matrix[i][j]=0;
		}
	    }
	}
    }
}

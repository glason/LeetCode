/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 */
public class Solution {
    public void rotate(int[][] matrix) {
	int len = matrix.length;
	int level=len/2;
	for(int i=0;i<level;i++){
	    for(int j=i;j<len-i-1;j++){
		int tmp=matrix[i][j];
		matrix[i][j]=matrix[len-j-1][i];
		matrix[len-j-1][i]=matrix[len-i-1][len-j-1];
		matrix[len-i-1][len-j-1]=matrix[j][len-i-1];
		matrix[j][len-i-1]=tmp;
	    }
	}
    }
}

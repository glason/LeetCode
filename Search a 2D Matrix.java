/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   3,  5,  7],
 *     [10, 11, 16, 20],
 *       [23, 30, 34, 50]
 *       ]
 *       Given target = 3, return true.
 */
public class Solution {
    int[][] matrix;
    int m,n,target;
    public boolean searchMatrix(int[][] matrix, int target) {
	if(matrix==null || matrix.length==0||matrix[0].length==0){
	    return false;
	}
	this.matrix=matrix;
	this.target=target;
	m=matrix.length;
	n=matrix[0].length;
	return search(0,m*n-1);
    }
    private boolean search(int start,int end){
	if(start>end){
	    return false;
	}
	int middle=(start+end)/2;
	if(matrix[middle/n][middle%n]==target){
	    return true;
	}
	if(matrix[middle/n][middle%n]>target){
	    return search(start,middle-1);
	}else{
	    return search(middle+1,end);
	}
    }
}

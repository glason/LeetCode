/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 *
 * [
 *  [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *    [ 7, 8, 9 ]
 *    ]
 *    You should return [1,2,3,6,9,8,7,4,5].
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
	List<Integer> result=new ArrayList<>();
	int m=matrix.length;
	int n=m==0?0:matrix[0].length;
	int level=(int)Math.min(Math.ceil(m/2.0),Math.ceil(n/2.0));
	if(level==0){
	    return result;
	}
	for(int l=0;l<level;l++){
	    if(2*l==m-1){
		for(int j=l;j<n-l;j++){
		    result.add(matrix[l][j]);
		}
		continue;
	    }else if(2*l==n-1){
		for(int i=l;i<m-l;i++){
		    result.add(matrix[i][l]);
		}
		continue;
	    }
	    for(int j=l;j<n-l-1;j++){
		result.add(matrix[l][j]);
	    }
	    for(int i=l;i<m-l-1;i++){
		result.add(matrix[i][n-l-1]);
	    }
	    for(int j=n-l-1;j>l;j--){
		result.add(matrix[m-l-1][j]);
	    }
	    for(int i=m-l-1;i>l;i--){
		result.add(matrix[i][l]);
	    }
	}
	return result;
    }
}

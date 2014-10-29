/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *        [2],
 *       [3,4],
 *      [6,5,7],
 *     [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
	if(triangle==null||triangle.size()==0){
	    return 0;
	}
	int size=triangle.size();
	int[] min=new int[triangle.get(size-1).size()];
	for(int i=size-1;i>=0;i--){
	    List<Integer> row=triangle.get(i);
	    for(int j=0;j<row.size();j++){
		if(i==size-1){
		    min[j]=row.get(j);
		}else{
		    min[j]=Math.min(min[j],min[j+1])+row.get(j);
		}
	    }
	}
	return min[0];
    }
}

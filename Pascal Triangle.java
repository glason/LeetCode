/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 *
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
	List<List<Integer>> result=new ArrayList<>();
	if(numRows==0){
	    return result;
	}
	int[] row=new int[numRows];
	row[0]=1;
	result.add(getList(row,1));
	for(int i=1;i<numRows;i++){
	    for(int j=i;j>0;j--){
		row[j]=row[j]+row[j-1];
	    }
	    result.add(getList(row,i+1));
	}
	return result;
    }
    private List<Integer> getList(int[] row,int len){
	List<Integer> list=new ArrayList<>();
	for(int i=0;i<len;i++){
	    list.add(row[i]);
	}
	return list;
    }
}

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
	int[] row=new int[rowIndex+1];
	row[0]=1;
	for(int i=1;i<=rowIndex;i++){
	    int pre=row[0];
	    for(int j=1;j<i;j++){
		int tmp=pre+row[j];
		pre=row[j];
		row[j]=tmp;
	    }
	    row[i]=1;
	}
	List<Integer> result=new ArrayList<>();
	for(int i:row){
	    result.add(i);
	}
	return result;
    }
}

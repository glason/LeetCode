/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 *
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
	int max=(int)Math.pow(2,S.length);
	List<List<Integer>> result=new ArrayList<>();
	Arrays.sort(S);
	for(int i=0;i<max;i++){
	    List<Integer> sub=new ArrayList<>();
	    for(int j=i,k=0;j>0;j=j>>1,k++){
		if(j%2==1){
		    sub.add(S[k]);
		}    
	    }
	    result.add(sub);
	}
	return result;
    }
}

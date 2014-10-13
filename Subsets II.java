/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 *
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
	Arrays.sort(num);
	List<List<Integer>> result=new ArrayList<>();
	subsets(result,new ArrayList<Integer>(),0,num);
	return result;
    }
    private void subsets(List<List<Integer>> result,List<Integer> solution,int start,int[] num){
	result.add(new ArrayList<Integer>(solution));
	for(int i=start;i<num.length;i++){
	    if(i!=start&&num[i]==num[i-1]){
		continue;
	    }
	    solution.add(num[i]);
	    subsets(result,solution,i+1,num);
	    solution.remove(solution.size()-1);
	}
    }
}

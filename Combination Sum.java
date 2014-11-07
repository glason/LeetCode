/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	Arrays.sort(candidates);
	List<List<Integer>> result=new ArrayList<>();
	dfs(result,new ArrayList<Integer>(),0,0,candidates,target);
	return result;
    }
    private void dfs(List<List<Integer>> result,List<Integer> solution,int sum,int start,int[] candidates,int target){
	if(sum>=target){
	    if(sum==target){
		result.add(new ArrayList<>(solution));
	    }
	    return;
	} 
	for(int i=start;i<candidates.length;i++){
	    solution.add(candidates[i]);
	    dfs(result,solution,sum+candidates[i],i,candidates,target);
	    solution.remove(solution.size()-1);
	}
    }
}

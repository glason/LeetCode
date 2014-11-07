/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
	Arrays.sort(num);
	List<List<Integer>> result=new ArrayList<>();
	dfs(result,new ArrayList<Integer>(),0,0,num,target);
	return result;   
    }
    private void dfs(List<List<Integer>> result,List<Integer> solution,int sum,int start,int[] num,int target){
	if(sum>=target){
	    if(sum==target){
		result.add(new ArrayList<>(solution));
	    }
	    return;
	} 
	for(int i=start;i<num.length;i++){
	    if(i>start&&num[i]==num[i-1]){
		continue;
	    }
	    solution.add(num[i]);
	    dfs(result,solution,sum+num[i],i+1,num,target);
	    solution.remove(solution.size()-1);
	}
    }
}

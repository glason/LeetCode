/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
	List<String> result=new ArrayList<>();
	dfs(result,"",new int[]{n,0});
	return result;
    }
    private void dfs(List<String> result,String solution,int[] choice){
	if(choice[0]==0&&choice[1]==0){
	    result.add(solution);
	    return;
	}
	if(choice[0]!=0){
	    choice[0]--;
	    choice[1]++;
	    dfs(result,solution+"(",choice);
	    choice[0]++;
	    choice[1]--;
	}
	if(choice[1]!=0){
	    choice[1]--;
	    dfs(result,solution+")",choice);
	    choice[1]++;
	}
    }
}

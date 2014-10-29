/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 *   [
 *    ["aa","b"],
 *    ["a","a","b"]
 *   ]
 *Hide Tags
 */
public class Solution {
    public List<List<String>> partition(String s) {
	int len=s.length();
	List<List<String>> result=new ArrayList<>();
	List<String> solution=new ArrayList<>();
	boolean[][] dp=new boolean[len][len+1];
	for(int i=0;i<len;i++){
	    dp[i][1]=true;
	}
	for(int l=2;l<=len;l++){
	    for(int st=0;st+l<=len;st++){
		if(l>3&&!dp[st+1][l-2]){
		    dp[st][l]=false;
		    continue;
		}
		dp[st][l]=s.charAt(st)==s.charAt(st+l-1);
	    }
	}
	dfs(result,solution,0,dp,s);
	return result;
    }
    private void dfs(List<List<String>> result,List<String> solution,int start,boolean[][] dp,String s){
	int len=s.length();
	if(start==len){
	    List<String> list=new ArrayList<>(solution);
	    result.add(list);
	    return;
	}
	for(int l=1;l+start<=len;l++){
	    if(dp[start][l]){
		solution.add(s.substring(start,start+l));
		dfs(result,solution,start+l,dp,s);
		solution.remove(solution.size()-1);
	    }
	}
    }
}

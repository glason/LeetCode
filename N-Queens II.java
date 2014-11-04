/**
 * Follow up for N-Queens problem.
 *
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 */
public class Solution {
    public int totalNQueens(int n) {
	return dfs(new int[n],0);
    }
    private int dfs(int[] q,int step){
	int n=q.length;
	if(step==n){
	    return 1;
	}
	int sum=0;
	for(int i=0;i<n;i++){
	    q[step]=i;
	    if(valid(q,step)){
		sum+=dfs(q,step+1);
	    }
	}
	return sum;
    }
    private boolean valid(int[] queen,int step){
	for(int i=0;i<step;i++){
	    if(queen[step]==queen[i]||step-i==Math.abs(queen[step]-queen[i])){
		return false;
	    }
	}
	return true;
    }
}

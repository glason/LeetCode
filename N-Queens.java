/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 *  ]
 * Show Tags
 *
 */
public class Solution {
    public List<String[]> solveNQueens(int n) {
	List<String[]> result=new ArrayList<>();
	dfs(result,new int[n],0);
	return result;
    }
    private void dfs(List<String[]> result,int[] queen,int step){
	int n=queen.length;
	if(step==n){
	    addList(result,queen);
	    return;
	}
	for(int i=0;i<n;i++){
	    queen[step]=i;
	    if(valid(queen,step)){
		dfs(result,queen,step+1);
	    }
	}
    }
    private boolean valid(int[] queen,int step){
	for(int i=0;i<step;i++){
	    if(queen[step]==queen[i]||step-i==Math.abs(queen[step]-queen[i])){
		return false;
	    }
	}
	return true;
    }
    private void addList(List<String[]> result,int[] queen){
	int n=queen.length;
	String[] ss=new String[n];
	for(int i=0;i<n;i++){
	    StringBuilder sb=new StringBuilder();
	    for(int j=0;j<n;j++){
		if(j==queen[i]){
		    sb.append("Q");
		}else{
		    sb.append(".");
		}
	    }
	    ss[i]=sb.toString();
	}
	result.add(ss);
    }
}

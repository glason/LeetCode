/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
	int m=board.length,n=board[0].length;
	if(m*n==0){
	    return false;
	}
	boolean[] log=new boolean[m*n];
	for(int i=0;i<m*n;i++){
	    if(word.charAt(0)==board[i/n][i%n]){
		if(dfs(board,word.substring(1),i,log)){
		    return true;
		}
	    }
	}
	return false;
    }
    private boolean dfs(char[][] board,String word,int step,boolean[] log){
	if(word.length()==0){
	    return true;
	}
	log[step]=true;
	int m=board.length;
	int n=board[0].length;
	boolean result=false;
	if(!result&&step%n!=0){
	    int left=step-1;
	    if(!log[left]&&board[left/n][left%n]==word.charAt(0)){
		result|=dfs(board,word.substring(1),left,log);
	    }
	}
	if(!result&&step%n!=n-1){
	    int right=step+1;
	    if(!log[right]&&board[right/n][right%n]==word.charAt(0)){
		result|=dfs(board,word.substring(1),right,log);
	    }
	}
	if(!result&&step/n!=0){
	    int top=step-n;
	    if(!log[top]&&board[top/n][top%n]==word.charAt(0)){
		result|=dfs(board,word.substring(1),top,log);
	    }
	}
	if(!result&&step/n!=m-1){
	    int bottom=step+n;
	    if(!log[bottom]&&board[bottom/n][bottom%n]==word.charAt(0)){
		result|=dfs(board,word.substring(1),bottom,log);
	    }
	}
	log[step]=false;
	return result;
    }
}

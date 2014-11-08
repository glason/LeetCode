/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character '.'.
 *
 * You may assume that there will be only one unique solution.
 *
 *
 * A sudoku puzzle...
 *
 *
 * ...and its solution numbers marked in red.
 */
public class Solution {
    public void solveSudoku(char[][] board) {
	int[] row=new int[9];
	int[] col=new int[9];
	int[] cel=new int[9];
	for(int i=0;i<9;i++){
	    for(int j=0;j<9;j++){
		if(board[i][j]=='.'){
		    continue;
		}
		int val=board[i][j]-'0';
		row[i]|=1<<val;
		col[j]|=1<<val;
		cel[i/3*3+j/3]|=1<<val;
	    }
	}
	dfs(board,row,col,cel,0);
    }
    private boolean dfs(char[][] board,int[] row,int[] col,int[] cel,int step){
	if(step==81){
	    return true;
	}
	int x=step/9;
	int y=step%9;
	if(board[x][y]=='.'){
	    for(int v=1;v<=9;v++){
		if(valid(row,col,cel,v,step)){
		    board[x][y]=(char)(v+'0');
		    row[x]|=1<<v;
		    col[y]|=1<<v;
		    cel[x/3*3+y/3]|=1<<v;
		    if(dfs(board,row,col,cel,step+1)){
			return true;
		    }
		    row[x]&=~(1<<v);
		    col[y]&=~(1<<v);
		    cel[x/3*3+y/3]&=~(1<<v);
		}
	    }
	    board[x][y]='.';
	    return false;
	}else{
	    return dfs(board,row,col,cel,step+1);
	}
    }
    private boolean valid(int[] row,int[] col,int[] cel,int val,int index){
	int x=index/9;
	int y=index%9;
	if((row[x]&(1<<val))>0){
	    return false;
	}
	if((col[y]&(1<<val))>0){
	    return false;
	}
	if((cel[x/3*3+y/3]&(1<<val))>0){
	    return false;
	}
	return true;
    }
}

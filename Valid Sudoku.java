/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 *
 * A partially filled sudoku which is valid.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
	int[] row=new int[9];
	int[] col=new int[9];
	int[] cel=new int[9];
	for(int i=0;i<9;i++){
	    for(int j=0;j<9;j++){
		if(board[i][j]=='.'){
		    continue;
		}
		int c=board[i][j]-'0';
		if((row[i]&(1<<c))>0){
		    return false;
		}
		row[i]|=(1<<c);
		if((col[j]&(1<<c))>0){
		    return false;
		}
		col[j]|=(1<<c);
		int index=(i/3)*3+j/3;
		if((cel[index]&(1<<c))>0){
		    return false;
		}
		cel[index]|=(1<<c);
	    }
	}
	return true;
    }
}

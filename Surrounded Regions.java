/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class Solution {
    int m,n;
    char[][] board;
    Queue<Point> queue;
    public void solve(char[][] board) {
	if(board==null||board.length==0||board[0].length==0){
	    return;
	} 
	this.board=board;
	m=board.length;
	n=board[0].length;
	queue = new LinkedList<Point>();
	for(int i=0;i<m;i++){
	    bfs(i,0);
	    bfs(i,n-1);
	}
	for(int j=1;j<n-1;j++){
	    bfs(0,j);
	    bfs(m-1,j);
	}
	for(int i=0;i<m;i++){
	    for(int j=0;j<n;j++){
		if(board[i][j]=='V'){
		    board[i][j]='O';
		}else{
		    board[i][j]='X';
		}
	    }
	}
    }
    private void fill(int x,int y){
	if(x<0||x>=m||y<0||y>=n||board[x][y]!='O'){
	    return;
	}
	board[x][y]='V';
	queue.offer(new Point(x,y));
    }
    private void bfs(int x,int y){
	fill(x,y);
	while(!queue.isEmpty()){
	    Point p = queue.poll();
	    fill(p.x+1,p.y);
	    fill(p.x-1,p.y);
	    fill(p.x,p.y+1);
	    fill(p.x,p.y-1);
	}
    }
    private class Point{
	int x;
	int y;
	public Point(int x,int y){
	    this.x=x;
	    this.y=y;
	}
    }
}

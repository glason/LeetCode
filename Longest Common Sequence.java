/**
 * char[] a and char[] b longest common sequence
 */
public class Solution{
    public char[] LCS(char[] a,char[] b){
	if(a==null || a.length==0 || b==null || b.length==0){
	    return null;
	}
	int[][] c = new int[a.length + 1][b.length + 1];
	for (int i = 0; i <= a.length; i++) {
	    c[i][0] = 0;
	}
	for (int j = 0; j <= b.length; j++) {
	    c[0][j] = 0;
	}
	for (int i = 1; i <= a.length; i++) {
	    for (int j = 1; j <= b.length; j++) {
		if (a[i - 1] == b[j - 1]) {
		    c[i][j] = c[i - 1][j - 1] + 1;
		} else if (c[i - 1][j] > c[i][j - 1]) {
		    c[i][j] = c[i - 1][j];
		} else {
		    c[i][j] = c[i][j - 1];
		}
	    }
	}
	char[] lcs = new char[c[a.length][b.length]];
	int index = lcs.length - 1;
	for (int i = a.length, j = b.length; i > 0 && j > 0;) {
	    if (c[i][j] == c[i - 1][j]) {
		i--;
	    } else if (c[i][j] == c[i][j - 1]) {
		j--;
	    } else {
		lcs[index--] = a[i - 1];
		i--;
		j--;
	    }
	}
	return lcs;
    }
}


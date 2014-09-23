/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 *
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
	if(s1==null||s2==null|s3==null||s3.length()!=s1.length()+s2.length()){
	    return false;
	}
	boolean[][] b = new boolean[s1.length()+1][s2.length()+1];
	b[0][0]=true;
	for(int i=1;i<=s1.length();i++){
	    b[i][0]=b[i-1][0]&s1.charAt(i-1)==s3.charAt(i-1);
	}
	for(int j=1;j<=s2.length();j++){
	    b[0][j]=b[0][j-1]&s2.charAt(j-1)==s3.charAt(j-1);
	}
	for(int i=1;i<=s1.length();i++){
	    for(int j=1;j<=s2.length();j++){
		b[i][j]=(b[i-1][j]&s1.charAt(i-1)==s3.charAt(i+j-1))|(b[i][j-1]&s2.charAt(j-1)==s3.charAt(i+j-1));
	    }
	}
	return b[s1.length()][s2.length()];
    }
}

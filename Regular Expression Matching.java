/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class Solution {
    public boolean isMatch(String s, String p) {
	int slen=s.length(),plen=p.length();
	boolean[][] dp=new boolean[slen+1][plen+1];
	for(int i=0;i<=slen;i++){
	    for(int j=0;j<=plen;j++){
		if(i==0&&j==0){
		    dp[i][j]=true;
		}else if(i==0){
		    if(p.charAt(j-1)=='*'){
			dp[i][j]=dp[i][j-2];    
		    }else{
			dp[i][j]=false;                        
		    }    
		}else if(j==0){
		    dp[i][j]=false;
		}else{
		    char cp=p.charAt(j-1);
		    if(cp=='*'){
			dp[i][j]|=dp[i-1][j-2]&&match(s.charAt(i-1),p.charAt(j-2));
			dp[i][j]|=dp[i-1][j]&&match(s.charAt(i-1),p.charAt(j-2));
			dp[i][j]|=dp[i][j-2];
		    }else if(cp=='.'){
			dp[i][j]=dp[i-1][j-1];        
		    }else{
			dp[i][j]=dp[i-1][j-1]&&cp==s.charAt(i-1);
		    }
		}
	    }
	}
	return dp[slen][plen];
    }
    private boolean match(char a,char b){
	return a==b||b=='.';
    }
}

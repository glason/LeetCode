/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
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
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class Solution {
    public boolean isMatch(String s, String p) {
	int sl = s.length();
	int sp = p.length();
	int _sp = 0;
	for (int i = 0; i < sp; i++) {
	    if (p.charAt(i) != '*') {
		_sp++;
	    }
	}
	if (_sp > sl) {
	    return false;
	}
	boolean[][] dp = new boolean[2][sp + 1];
	for (int i = 0; i <= sl; i++) {
	    for (int j = 0; j <= sp; j++) {
		if (j == 0) {
		    dp[i % 2][j] = i == 0;
		} else {
		    int preX = Math.abs(i - 1) % 2;
		    dp[i % 2][j] = false;
		    if (dp[i % 2][j - 1] || dp[preX][j]) {
			dp[i % 2][j] |= p.charAt(j - 1) == '*';
		    }
		    if (dp[preX][(j - 1)]) {
			char cs = s.charAt(i - 1);
			char cp = p.charAt(j - 1);
			dp[i % 2][j] |= (cs == cp || cp == '*' || cp == '?');
		    }
		}
	    }
	}
	return dp[sl % 2][sp];
    }
}

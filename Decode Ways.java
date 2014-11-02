/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 */
public class Solution {
    public int numDecodings(String s) {
	int len=s.length();
	if(len==0||s.charAt(0)=='0'){
	    return 0;
	}
	int[] dp=new int[len+1];
	dp[0]=dp[1]=1;
	for(int i=2;i<=len;i++){
	    if(s.charAt(i-1)!='0'){
		dp[i]+=dp[i-1];
	    }
	    String sub=s.substring(i-2,i);
	    if(valid(sub)){
		dp[i]+=dp[i-2];
	    }
	    if(dp[i]==0){
		return 0;
	    }
	}
	return dp[len];
    }
    private boolean valid(String s){
	if(s.charAt(0)=='0'||s.compareTo("26")>0){
	    return false;
	}
	return true;
    }
}

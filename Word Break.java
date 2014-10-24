/**
*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

*For example, given
*s = "leetcode",
*dict = ["leet", "code"].

*Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len=s.length();
        boolean[][] dp=new boolean[len][len+1];
        for(int l=1;l<=len;l++){
            for(int st=0;st+l<=len;st++){
                if(dict.contains(s.substring(st,st+l))){
                    dp[st][l]=true;
                }else{
                    for(int k=1;k<l;k++){
                        if(dp[st][k]&&dp[st+k][l-k]){
                            dp[st][l]=true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][len];
    }
}

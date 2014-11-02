/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 *
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
//Time Out Version
public class Solution {
    public String minWindow(String S, String T) {
	Set<Character> set=new HashSet<>();
	for(int i=0;i<T.length();i++){
	    set.add(T.charAt(i));
	}
	Map<Character,Integer> map=new HashMap<>();
	int val=1;
	int all=0;
	for(Character c:set){
	    map.put(c,val);
	    all+=val;
	    val=val<<1;
	}
	int[][] dp=new int[S.length()+1][S.length()+1];
	for( int l=1;l<=S.length();l++){
	    for(int i=0;i+l<=S.length();i++){
		char c=S.charAt(i);
		if(set.contains(c)){
		    dp[i][l]=dp[i+1][l-1]+map.get(c);
		}else{
		    dp[i][l]=dp[i+1][l-1];
		}
		if(dp[i][l]==all){
		    return S.substring(i,i+l);
		}
	    }
	}
	return "";
    }
}
public class Solution {
    private static final int LEN=256;
    public String minWindow(String S, String T) {
	int left=0,right=Integer.MAX_VALUE;
	int[] tcount=new int[LEN];
	int[] scount=new int[LEN];
	for(int i=0;i<T.length();i++){
	    tcount[T.charAt(i)]++;
	}
	int count=0;
	for(int r=0,l=0;r<S.length();r++){
	    int cr=S.charAt(r);
	    if(scount[cr]<tcount[cr]){
		count++;
	    }    
	    scount[cr]++;
	    if(count==T.length()){
		while(l<=r){
		    int cl=S.charAt(l);
		    if(scount[cl]>tcount[cl]){
			scount[cl]--;
			l++;
		    }else{
			break;
		    }
		}
		if(r-l<right-left){
		    right=r;
		    left=l;
		}
		scount[S.charAt(l)]--;
		count--;
		l++;
	    }
	}
	if(right-left<S.length()){
	    return S.substring(left,right+1);
	}
	return "";
    }
}

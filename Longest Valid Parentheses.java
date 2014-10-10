/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class Solution {
    public int longestValidParentheses(String s) {
	int res=0;
	int n=s.length();
	int[] dp=new int[n];
	for(int i=n-2;i>=0;i--){
	    if(s.charAt(i)=='('){
		int j=i+dp[i+1]+1;
		if(j<n&&s.charAt(j)==')'){
		    dp[i]=dp[i+1]+2;
		    if(j+1<n){
			dp[i]+=dp[j+1];
		    }
		    res=Math.max(res,dp[i]);
		}
	    }
	}
	return res;
    }
}
public class Solution {
    public int longestValidParentheses(String s) {
	int res=0;
	Stack<Integer> stack = new Stack<>();
	for(int i=0;i<s.length();i++){
	    char c=s.charAt(i);
	    if(c==')'&&!stack.isEmpty()&&s.charAt(stack.peek())=='('){
		stack.pop();
		if(stack.isEmpty()){
		    res=i+1;
		}else{
		    res=Math.max(res,i-stack.peek());
		}
	    }else{
		stack.push(i);
	    }
	}
	return res;
    }
}

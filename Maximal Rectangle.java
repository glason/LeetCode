/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
	if(matrix.length==0||matrix[0].length==0){
	    return 0;
	}
	int m=matrix.length,n=matrix[0].length;
	int[] dp=new int[n];
	int result=0;
	for(int i=0;i<m;i++){
	    for(int j=0;j<n;j++){
		if(matrix[i][j]=='1'){
		    dp[j]++;
		}else{
		    dp[j]=0;
		}
	    }
	    result=Math.max(result,maxArea(dp));   
	}
	return result;
    }
    private int maxArea(int[] height){
	int len=height.length;
	if(len==0){
	    return 0;
	}
	int area=0;
	Stack<Integer> stack=new Stack<>();
	for(int i=0;i<=len;i++){
	    while(!stack.isEmpty()&&(i==len||height[stack.peek()]>height[i])){
		int h=height[stack.pop()];
		int w=stack.isEmpty()?i:i-stack.peek()-1;
		area=Math.max(area,h*w);  
	    }
	    stack.push(i);
	}
	return area;
    }
}

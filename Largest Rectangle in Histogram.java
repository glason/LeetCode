/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
	int len=height.length;
	if(len==0){
	    return 0;
	}
	int result=0;
	Stack<Integer> stack=new Stack<>();
	for(int i=0;i<=len;i++){
	    while(!stack.isEmpty()&&(i==len||height[stack.peek()]>height[i])){
		int h=height[stack.pop()];
		int w=stack.isEmpty()?i:i-stack.peek()-1;
		result=Math.max(result,h*w);
	    }
	    stack.push(i);
	}
	return result;
    }
}

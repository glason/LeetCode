/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Solution {
    public int maxProfit(int[] prices) {
	int len=prices.length;
	if(len==0){
	    return 0;
	}
	int[] left=new int[len];
	int[] right=new int[len];
	int min=prices[0];
	for(int i=1;i<len;i++){
	    left[i]=Math.max(left[i-1],prices[i]-min);
	    min=Math.min(min,prices[i]);
	}
	int max=prices[len-1];
	for(int i=len-2;i>=0;i--){
	    right[i]=Math.max(right[i+1],max-prices[i]);
	    max=Math.max(max,prices[i]);
	}
	int result=0;
	for(int i=1;i<len;i++){
	    result=Math.max(result,left[i-1]+right[i]);
	}
	result=Math.max(result,left[len-1]);
	return result;
    }
}

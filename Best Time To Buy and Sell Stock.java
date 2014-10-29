/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class Solution {
    public int maxProfit(int[] prices) {
	int result=0;
	int len=prices.length;
	if(len<2){
	    return 0;
	}
	int[] max=new int[len];
	max[len-1]=prices[len-1];
	for(int i=len-2;i>=0;i--){
	    result=Math.max(result,max[i+1]-prices[i]);
	    max[i]=Math.max(prices[i],max[i+1]);
	}
	return result;
    }
}

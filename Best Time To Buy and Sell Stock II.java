/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Solution {
    public int maxProfit(int[] prices) {
	int sum=0;
	int pre=0;
	int len=prices.length;
	for(int i=1;i<len;i++){
	    if(prices[i]<prices[i-1]){
		if(i-1>pre){
		    sum+=prices[i-1]-prices[pre];
		}
		pre=i;
	    }
	}
	if(len>0&&pre!=len-1){
	    sum+=prices[len-1]-prices[pre];
	}
	return sum;
    }
}

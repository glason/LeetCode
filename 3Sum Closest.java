/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 *         The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
	Arrays.sort(num);
	int len=num.length;
	Integer result=null;
	for(int i=0;i<len-2;i++){
	    int l=i+1,r=len-1;
	    while(l<r){
		int sum=num[l]+num[r];
		if(result==null||Math.abs(target-sum-num[i])<Math.abs(target-result)){
		    result=sum+num[i];
		}
		if(sum==target-num[i]){
		    return target;
		}else if(sum<target-num[i]){
		    l++;
		}else{
		    r--;
		}
	    }
	}
	return result;
    }
}

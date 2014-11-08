/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 *         A solution set is:
 *             (-1,  0, 0, 1)
 *                 (-2, -1, 1, 2)
 *                     (-2,  0, 0, 2)
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
	Arrays.sort(num);
	List<List<Integer>> result=new ArrayList<>();
	int len=num.length;
	for(int i=0;i<len;i++){
	    if(i>0&&num[i]==num[i-1]){
		continue;
	    }
	    for(int j=i+1;j<len;j++){
		if(j>i+1&&num[j]==num[j-1]){
		    continue;
		}
		int l=j+1,r=len-1;
		int subTarget=target-num[i]-num[j];
		while(l<r){
		    int sum=num[l]+num[r];
		    if(sum==subTarget){
			List<Integer> list=new ArrayList<>();
			list.add(num[i]);
			list.add(num[j]);
			list.add(num[l]);
			list.add(num[r]);
			result.add(list);
			while(num[++l]==num[l-1]&&l<r);
			while(num[--r]==num[r+1]&&l<r);
		    }else if(sum<subTarget){
			l++;
		    }else{
			r--;
		    }
		}
	    }
	}
	return result;
    }
}

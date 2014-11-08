/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *     For example, given array S = {-1 0 1 2 -1 -4},
 *
 *         A solution set is:
 *             (-1, 0, 1)
 *                 (-1, -1, 2)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
	Arrays.sort(num);
	List<List<Integer>> result=new ArrayList<>();
	int len=num.length;
	for(int i=0;i<len;i++){
	    if(i>0&&num[i]==num[i-1]){
		continue;
	    }
	    int l=i+1,r=len-1;
	    while(l<r){
		int sum=num[l]+num[r];
		if(sum==-num[i]){
		    List<Integer> list=new ArrayList<>();
		    list.add(num[i]);
		    list.add(num[l]);
		    list.add(num[r]);
		    result.add(list);
		    while(num[++l]==num[l-1]&&l<r);
		    while(num[--r]==num[r+1]&&l<r);
		}else if(sum<-num[i]){
		    l++;
		}else{
		    r--;
		}
	    }
	}
	return result;
    }
}

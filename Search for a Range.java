/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {
	int result=bsearch(A,target,0,A.length-1);
	if(result==-1){
	    return new int[]{-1,-1};
	}else{
	    int l=result,r=result;
	    while(l>=0&&A[l]==target){
		l--;
	    }
	    while(r<=A.length-1&&A[r]==target){
		r++;
	    }
	    return new int[]{l+1,r-1};
	}
    }
    private int bsearch(int[] A,int target,int s,int e){
	if(s>e){
	    return -1;
	}
	int m=(s+e)/2;
	if(A[m]==target){
	    return m;
	}else if(target<A[m]){
	    return bsearch(A,target,s,m-1);
	}else{
	    return bsearch(A,target,m+1,e);
	}
    }
}

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 */
public class Solution {
    public int search(int[] A, int target) {
	return binary(A,target,0,A.length-1);        
    }
    private int binary(int[] A,int target,int s,int e){
	if(s>e){
	    return -1;
	}
	int m=(s+e)/2;
	if(A[m]==target){
	    return m;
	}
	if(A[m]<A[s]&&A[m]<A[e]){
	    if(target<A[m]||target>A[e]){
		return binary(A,target,s,m-1);
	    }else{
		return binary(A,target,m+1,e);
	    }    
	}else if(A[m]>=A[s]&&A[m]>A[e]){
	    if(target>A[m]||target<A[s]){
		return binary(A,target,m+1,e);
	    }else{
		return binary(A,target,s,m-1);
	    }    
	}else{
	    if(target<A[m]){
		return binary(A,target,s,m-1);
	    }else{
		return binary(A,target,m+1,e);
	    }
	}
    }
}

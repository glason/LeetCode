/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 *
 * Write a function to determine if a given target is in the array.
 */
public class Solution {
    public boolean search(int[] A, int target) {
	int index=0;
	for(int i=0;i<A.length;i++){
	    if(i==0||A[i]!=A[index-1]){
		A[index++]=A[i];
	    }
	}
	if(index!=1&&A[index-1]==A[0]){
	    index--;
	}
	return binary(A,target,0,index-1);    
    }
    private boolean binary(int[] A,int target,int s,int e){
	if(s>e){
	    return false;
	}
	int m=(s+e)/2;
	if(A[m]==target){
	    return true;
	}
	if(A[m]<=A[s]&&A[m]<A[e]){
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

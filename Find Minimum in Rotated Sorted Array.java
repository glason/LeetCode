/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 */
public class Solution {
    public int findMin(int[] num) {
	return recursive(num,0,num.length-1);
    }
    private int recursive(int[] num,int l,int r){
	if(l==r){
	    return num[l];
	}
	int mid=(l+r)/2;
	if(num[mid]<num[r]){
	    return recursive(num,l,mid);
	}else{
	    return recursive(num,mid+1,r);
	}
    }
}

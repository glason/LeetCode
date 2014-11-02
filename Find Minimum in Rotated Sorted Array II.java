/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 */
public class Solution {
    public int findMin(int[] num) {
	int index=0;
	for(int i=0;i<num.length;i++){
	    if(i==0||num[i]!=num[index-1]){
		num[index++]=num[i];    
	    }
	}
	if(index>1&&num[0]==num[index-1]){
	    index--;
	}
	return dfs(num,0,index-1);
    }
    private int dfs(int[] num,int l,int r){
	if(num[l]<=num[r]){
	    return num[l];
	}
	int m=(l+r)/2;
	if(num[m]<num[r]){
	    return dfs(num,l,m);
	}else{
	    return dfs(num,m+1,r);
	}
    }
}
public class Solution {
    public int findMin(int[] num) {
	int l=0,r=num.length-1;
	while(l<r){
	    if(num[l]<num[r]){
		break;
	    }
	    int m=(l+r)/2;
	    if(num[m]<num[r]){
		r=m;
	    }else if(num[m]==num[r]){
		l++;
		r--;
	    }else{
		l=m+1;
	    }
	}
	return num[l];
    }
}

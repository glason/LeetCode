/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 */
public class Solution {
    public int trap(int[] A) {
	int len=A.length;
	int[] maxL=new int[len];
	int[] maxR=new int[len];
	int sum=0;
	for(int i=0;i<len;i++){
	    maxL[i]=i==0?A[i]:Math.max(maxL[i-1],A[i]);
	}
	for(int i=len-1;i>=0;i--){
	    maxR[i]=i==len-1?A[i]:Math.max(maxR[i+1],A[i]);
	}
	for(int i=1;i<len-1;i++){
	    sum+=Math.max(0,Math.min(maxL[i-1],maxR[i+1])-A[i]);
	}
	return sum;
    }
}

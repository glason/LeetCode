/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class Solution {
    public int maxProduct(int[] A) {
	if(A.length==1){
	    return A[0];
	}
	int max=A[0];
	int pos=0;
	int neg=0;
	for(int a:A){
	    if(a>0){
		pos=Math.max(a,a*pos);
		neg=a*neg;
	    }else{
		int tmp=pos;
		pos=a*neg;
		neg=Math.min(a,a*tmp);
	    }
	    max=Math.max(max,pos);
	}
	return max;
    }
}

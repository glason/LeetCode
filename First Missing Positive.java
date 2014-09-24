/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 *
 */
public class Solution {
    public int firstMissingPositive(int[] A) {
	int i=0;
	while(i<A.length){
	    int a = A[i];
	    if(a>0&&a<=A.length&&a-1!=i&&a!=A[a-1]){//attention if a==A[a-1] infinite loop
		int t=A[a-1];
		A[a-1]=a;
		A[i]=t;
	    }else{
		i++;
	    }
	}
	for(int j=0;j<A.length;j++){
	    if(A[j]!=j+1){
		return j+1;
	    }
	}
	return A.length+1;//if all element in right place
    }
}

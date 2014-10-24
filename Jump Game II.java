/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 */
public class Solution {
    public int jump(int[] A) {
	int end=A.length-1;
	int step=0;
	while(end!=0){
	    for(int i=0;i<end;i++){
		if(A[i]+i>=end){
		    end=i;
		    step++;
		    break;
		}
	    }
	}
	return step;
    }
}

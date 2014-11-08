/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution {
    public void nextPermutation(int[] num) {
	if(!permutation(num)){
	    Arrays.sort(num);
	}    
    }
    private boolean permutation(int[] num){
	int desc=0;
	for(int i=num.length-1;i>0;i--){
	    if(num[i]>num[i-1]){
		desc=i;
		break;
	    }
	}
	if(desc==0){
	    return false;
	}
	for(int i=num.length-1;i>=desc;i--){
	    if(num[i]>num[desc-1]){
		swap(num,i,desc-1);
		break;
	    }
	}
	reverse(num,desc,num.length-1);
	return true;
    }
    private void swap(int[] num,int l,int r){
	int tmp=num[l];
	num[l]=num[r];
	num[r]=tmp;
    }
    private void reverse(int[] num,int l,int r){
	while(l<r){
	    swap(num,l,r);
	    l++;
	    r--;
	}
    }
}

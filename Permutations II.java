/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
	List<List<Integer>> result=new ArrayList<>();
	Arrays.sort(num);
	result.add(getList(num));
	while(nextPermutation(num)){
	    result.add(getList(num));
	}
	return result;   
    }
    private boolean nextPermutation(int[] num){
	int len=num.length;
	int desc=0;
	for(int i=len-1;i>0;i--){
	    if(num[i]>num[i-1]){
		desc=i;
		break;
	    }
	}
	if(desc==0){
	    return false;
	}
	for(int i=len-1;i>=desc;i--){
	    if(num[i]>num[desc-1]){
		swap(num,i,desc-1);
		break;
	    }
	}
	reverse(num,desc,len-1);
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
    private List<Integer> getList(int[] num){
	List<Integer> list=new ArrayList<>();
	for(int i:num){
	    list.add(i);
	}
	return list;
    }
}

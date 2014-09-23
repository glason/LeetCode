/**
 * Given a collection of numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 */
public class Solution {
    public List<List<Integer>> permute(int[] num) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	if(num==null || num.length==0){
	    result.add(new ArrayList<Integer>());
	}
	for(int i=0;i<num.length;i++){
	    List<List<Integer>> ls = permute(removeIndex(num,i));
	    for(List<Integer> l:ls ){
		l.add(num[i]);
		result.add(l);
	    }
	}
	return result;
    }
    private int[] removeIndex(int[] num,int index){
	int[] result = new int[num.length-1];
	for(int i=0,j=0;i<num.length;i++){
	    if(i!=index){
		result[j++]=num[i];
	    }
	}
	return result;
    }
}

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 */
public class Solution {
    public int longestConsecutive(int[] num) {
	Set<Integer> set=new HashSet<>();
	for(int i:num){
	    set.add(i);
	}
	int result=0;
	for(int i:num){
	    result=Math.max(result,getCount(set,i));
	}
	return result;
    }
    private int getCount(Set<Integer> set,int i){
	int count=1;
	int k=i;
	while(set.contains(--k)){
	    set.remove(k);
	    count++;
	}
	k=i;
	while(set.contains(++k)){
	    set.remove(k);
	    count++;
	}
	return count;
    }
}

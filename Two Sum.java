/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
//my solution
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
	int len=numbers.length;
	List<Bundle> list=new ArrayList<>();
	for(int i=0;i<len;i++){
	    list.add(new Bundle(i+1,numbers[i]));
	}
	Collections.sort(list,new Comparator<Bundle>(){
	    public int compare(Bundle a,Bundle b){
		return a.val-b.val;
	    } 
	});
	int i=0,j=len-1;
	while(i<j){
	    int sum=list.get(i).val+list.get(j).val;
	    if(sum==target){
		break;
	    }else if(sum<target){
		i++;
	    }else{
		j--;
	    }
	}
	int[] result=new int[]{list.get(i).index,list.get(j).index};
	Arrays.sort(result);
	return result;
    }
    class Bundle{
	int index;
	int val;
	Bundle(int i,int v){
	    index=i;
	    val=v;
	}
    }
}
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
	Map<Integer,Integer> map=new HashMap<>();
	int len=numbers.length;
	for(int i=0;i<len;i++){
	    if(map.containsKey(target-numbers[i])){
		return new int[]{map.get(target-numbers[i]),i+1};
	    }
	    map.put(numbers[i],i+1);
	}
	return new int[]{0,0};
    }
}

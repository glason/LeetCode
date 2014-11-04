/**
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * Note: All inputs will be in lower-case.
 */
public class Solution {
    public List<String> anagrams(String[] strs) {
	Map<String,Integer> map=new HashMap<>();
	List<String> result=new ArrayList<>();
	int len=strs.length;
	for(int i=0;i<len;i++){
	    String sort=sortString(strs[i]);
	    if(map.containsKey(sort)){
		int pre=map.get(sort);
		result.add(strs[i]);
		if(pre!=-1){
		    result.add(strs[pre]);
		    map.put(sort,-1);
		}
	    }else{
		map.put(sort,i);
	    }
	}
	return result;
    }
    private String sortString(String s){
	char[] cs=s.toCharArray();
	Arrays.sort(cs);
	return new String(cs);
    }
}

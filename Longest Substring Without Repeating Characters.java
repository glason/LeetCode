/**
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
	int last=0;
	int max=0;
	Map<Character,Integer> map = new HashMap<>();
	for(int i=0;i<s.length();i++){
	    char c = s.charAt(i);
	    if(map.containsKey(c)){
		max=Math.max(max,map.size());
		int end=map.get(c);
		for(int j=last;j<=end;j++){
		    map.remove(s.charAt(j));
		}
		last=end+1;
	    }
	    map.put(c,i);
	}
	return Math.max(max,map.size());
    }
}

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 *
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
	Queue<String> queue=new LinkedList<>();
	Map<String,Integer> map=new HashMap<>();
	queue.offer(start);
	map.put(start,1);
	while(!queue.isEmpty()){
	    String s=queue.poll();
	    int c=map.get(s);
	    for(int i=0;i<s.length();i++){
		for(int j=0;j<26;j++){
		    String next=s.substring(0,i)+(char)('a'+j)+s.substring(i+1,s.length());
		    if(next.equals(end)){
			return c+1;
		    }
		    if(dict.contains(next)){
			dict.remove(next);
			queue.offer(next);
			map.put(next,c+1);
		    }
		}
	    }
	}
	return 0;
    }
}

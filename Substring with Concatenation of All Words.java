/**
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 *
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
	int slen=S.length();
	int llen=L.length;
	int lword=L[0].length();
	int totalLen=llen*lword;
	Map<String,Integer> smap=new HashMap<>();
	Map<String,Integer> lmap=new HashMap<>();
	List<Integer> result=new ArrayList<>();
	for(String l:L){
	    addMap(lmap,l);   
	}
	for(int i=0;i+totalLen<=slen;i++){
	    smap.clear();
	    int j=i;
	    for(;j<i+totalLen;j+=lword){
		String sub=S.substring(j,j+lword);
		if(lmap.containsKey(sub)){
		    addMap(smap,sub);
		    if(smap.get(sub)>lmap.get(sub)){
			break;
		    }
		}else{
		    break;
		}
	    }
	    if(j==i+totalLen){
		result.add(i);
	    }
	}
	return result;
    }
    private void addMap(Map<String,Integer>map,String s){
	if(map.containsKey(s)){
	    map.put(s,map.get(s)+1);
	}else{
	    map.put(s,1);
	}
    }
}

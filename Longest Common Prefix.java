/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
	if(strs==null||strs.length==0){
	    return "";
	}
	StringBuilder sb=new StringBuilder();
	int index=0;
	while(true){
	    int i=0;
	    for(;i<strs.length;i++){
		if(index>=strs[i].length()||(i>0&&strs[i].charAt(index)!=strs[i-1].charAt(index))){
		    break;
		}
	    }
	    if(i==strs.length){
		sb.append(strs[0].charAt(index));
		index++;
	    }else{
		break;
	    }
	}
	return sb.toString();
    }
}

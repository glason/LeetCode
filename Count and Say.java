/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */
public class Solution {
    public String countAndSay(int n) {
	String s="1";
	for(int i=1;i<n;i++){
	    s=count(s);
	}
	return s;
    }
    private String count(String s){
	int i=0;
	StringBuilder sb=new StringBuilder();
	while(i<s.length()){
	    char w=s.charAt(i);
	    int c=1;
	    i++;
	    while(i<s.length()&&s.charAt(i)==w){
		i++;
		c++;
	    }
	    sb.append(String.valueOf(c));
	    sb.append(w);
	}
	return sb.toString();
    }
}

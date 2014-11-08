/**
 * Implement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Update (2014-11-02):
 * The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
	int hlen=haystack.length();
	int nlen=needle.length();
	for(int i=0;i+nlen<=hlen;i++){
	    int j=i;
	    for(;j<i+nlen;j++){
		if(haystack.charAt(j)!=needle.charAt(j-i)){
		    break;
		}
	    }
	    if(j==i+nlen){
		return i;
	    }
	}
	return -1;
    }
}

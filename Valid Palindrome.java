/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Solution {
    public boolean isPalindrome(String s) {
	if(s==null){
	    return true;
	}
	int i=0,j=s.length()-1;
	while(i<j){
	    while(i<s.length()&&!alphanumeric(s.charAt(i))){
		i++;
	    }
	    while(j>=0&&!alphanumeric(s.charAt(j))){
		j--; 
	    }
	    if(i>=j){
		break;
	    }
	    char ci=s.charAt(i);
	    char cj=s.charAt(j);
	    if(Character.toLowerCase(ci)!=Character.toLowerCase(cj)){
		return false;
	    }
	    i++;
	    j--;
	}
	return true;
    }
    private boolean alphanumeric(char c){
	return Character.isAlphabetic(c)|Character.isDigit(c);
    }
}

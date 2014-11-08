/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 *
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {
    private static final String[] TEL=new String[]{" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
	List<String> result=new ArrayList<>();
	dfs(result,"",digits,0);
	return result;
    }
    private void dfs(List<String> result,String solution,String digits,int index){
	int len=digits.length();
	if(index==len){
	    result.add(solution);
	    return;
	}
	if(digits.charAt(index)=='1'){
	    dfs(result,solution,digits,index+1);
	}else{
	    String choice=TEL[digits.charAt(index)-'0'];
	    for(int i=0;i<choice.length();i++){
		dfs(result,solution+choice.charAt(i),digits,index+1);
	    }
	}
    }
}

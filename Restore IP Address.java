/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
	List<String> result=new ArrayList<>();
	dfs(result,"",s,"255255255255");
	return result;
    }
    private void dfs(List<String> result,String solution,String s,String p){
	if(s.length()==0||p.length()==0){
	    if(s.length()==0&&p.length()==0){
		result.add(solution.substring(1));
	    }
	    return;
	}
	if(!validIP(s,p)){
	    return;
	}
	for(int i=1;i<=s.length();i++){
	    String sub=s.substring(0,i);
	    if(validIP(sub,"255")){
		dfs(result,solution+"."+sub,s.substring(i),p.substring(3));
	    }else{
		break;
	    }
	}
    }
    private boolean validIP(String s,String p){
	if(s.length()>p.length()||(s.length()==p.length()&&s.compareTo(p)>0)){
	    return false;
	}
	if(s.length()!=1&&p.length()==3&&s.charAt(0)=='0'){
	    return false;
	}
	return true;
    }
}

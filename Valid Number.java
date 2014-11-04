/**
 * Validate if a given string is numeric.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
public class Solution {
    public boolean isNumber(String s) {
	s=s.trim();
	if(s.length()==0){
	    return false;
	}
	if(s.contains("e")){
	    if(s.indexOf("e")!=s.lastIndexOf("e")){
		return false;
	    }
	    String[] ss=s.split("e");
	    if(ss.length!=2){
		return false;
	    }else{
		return isDou(removeSign(ss[0]))&&isPos(removeSign(ss[1]));
	    }
	}else{
	    return isDou(removeSign(s));
	}
    }
    private boolean isDou(String s){
	if(s.contains(".")){
	    if(s.indexOf(".")!=s.lastIndexOf(".")){
		return false;
	    }
	    String[] ss=s.split("\\.");
	    if(ss.length==1){
		return isPos(ss[0]);
	    }else if(ss.length==2){
		return (ss[0].length()==0||isPos(ss[0]))&&isPos(ss[1]);
	    }else{
		return false;
	    }
	}else{
	    return isPos(s);
	}
    }
    private String removeSign(String s){
	if(s.length()!=0&&(s.charAt(0)=='+'||s.charAt(0)=='-')){
	    return s.substring(1);
	}
	return s;
    }
    private boolean isPos(String s){
	if(s.length()==0){
	    return false;
	}
	for(int i=0;i<s.length();i++){
	    char c=s.charAt(i);
	    if(c<'0'||c>'9'){
		return false;
	    }
	}
	return true;
    }
}

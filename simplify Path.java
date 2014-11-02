/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class Solution {
    public String simplifyPath(String path) {
	Stack<String> stack=new Stack<>();
	String[] file=path.split("/");
	for(String f:file){
	    if(f.equals("")||f.equals(".")){
		continue;
	    }else if(f.equals("..")){
		if(!stack.isEmpty()){
		    stack.pop();
		}
	    }else{
		stack.push(f);
	    }
	}
	String result="";
	while(!stack.isEmpty()){
	    if(result.length()!=0){
		result="/"+result;
	    }
	    result=stack.pop()+result;
	}
	result="/"+result;
	return result;
    }
}

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class Solution {
    public String multiply(String num1, String num2) {
	int l1=num1.length(),l2=num2.length();
	int carry=0;
	String result="0";
	LinkedList<Character> list=new LinkedList<>();
	for(int i=l1-1;i>=0;i--){
	    list.clear();
	    for(int t=i;t<l1-1;t++){
		list.addFirst('0');
	    }
	    int mul=num1.charAt(i)-'0';
	    for(int j=l2-1;j>=0;j--){
		carry+=mul*(num2.charAt(j)-'0');
		list.addFirst((char)(carry%10+'0'));
		carry/=10;
	    }
	    if(carry>0){
		list.addFirst((char)(carry+'0'));
		carry=0;
	    }
	    result=add(result,getString(list));
	}
	return result;
    }
    private String add(String num1,String num2){
	int l1=num1.length()-1,l2=num2.length()-1,carry=0;
	LinkedList<Character> result=new LinkedList<>();
	while(l1>=0||l2>=0||carry>0){
	    if(l1>=0){
		carry+=num1.charAt(l1)-'0';
		l1--;
	    }
	    if(l2>=0){
		carry+=num2.charAt(l2)-'0';
		l2--;
	    }
	    result.addFirst((char)(carry%10+'0'));
	    carry/=10;
	}
	return getString(result);
    }
    private String getString(List<Character> list){
	StringBuilder sb=new StringBuilder();
	boolean zero=false;
	for(char c:list){
	    if(c=='0'){
		if(zero){
		    sb.append(c);
		}
	    }else{
		zero=true;
		sb.append(c);
	    }
	}
	return sb.length()==0?"0":sb.toString();
    }
}

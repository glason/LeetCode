/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class Solution {
    public String addBinary(String a, String b) {
	if(a==null||a.length()==0){
	    return b;
	}
	if(b==null || b.length()==0){
	    return a;
	}
	List<Character> list = new ArrayList<Character>();
	int carry=0;
	int i=a.length()-1,j=b.length()-1;
	for(;i>=0&&j>=0;i--,j--){
	    int ca=a.charAt(i)-'0',cb=b.charAt(j)-'0';
	    int sum=ca+cb+carry;
	    if(sum==0){
		carry=0;
		list.add('0');
	    }else if(sum==1){
		carry=0;
		list.add('1');
	    }else if(sum==2){
		carry=1;
		list.add('0');
	    }else{
		carry=1;
		list.add('1');
	    }
	}
	if(i>=0||j>=0){
	    int k= i>=0?i:j;
	    String s=i>=0?a:b;
	    for(;k>=0;k--){
		int cs=s.charAt(k)-'0';
		int sum = cs+carry;
		if(sum==0){
		    carry=0;
		    list.add('0');
		}else if(sum==1){
		    carry=0;
		    list.add('1');
		}else{
		    carry=1;
		    list.add('0');
		}
	    }
	}
	if(carry==1){
	    list.add('1');
	}
	StringBuilder sb = new StringBuilder();
	for(int k=list.size()-1;k>=0;k--){
	    sb.append(list.get(k));
	}
	return sb.toString();
    }
}

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
    public int romanToInt(String s) {
	int sum=0;
	Map<Character,Integer> map=new HashMap<>();
	roman(map);
	for(int i=0;i<s.length();i++){
	    char c=s.charAt(i);
	    if(i<s.length()-1&&map.get(c)<map.get(s.charAt(i+1))){
		sum-=map.get(c);
	    }else{
		sum+=map.get(c);
	    }
	}
	return sum;
    }
    private void roman(Map<Character,Integer> map){
	map.clear();
	map.put('I',1);
	map.put('V',5);
	map.put('X',10);
	map.put('L',50);
	map.put('C',100);
	map.put('D',500);
	map.put('M',1000);
    }
}

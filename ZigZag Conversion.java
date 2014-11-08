/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution {
    public String convert(String s, int nRows) {
	StringBuilder[] sbs=new StringBuilder[nRows];
	for(int i=0;i<nRows;i++){
	    sbs[i]=new StringBuilder();
	}
	int step=0,row=0;
	for(int i=0;i<s.length();i++){
	    sbs[row].append(s.charAt(i));
	    if(nRows==1){
		step=0;
	    }else if(row==0){
		step=1;
	    }else if(row==nRows-1){
		step=-1;
	    }
	    row+=step;
	}
	StringBuilder result=new StringBuilder();
	for(StringBuilder sb:sbs){
	    result.append(sb.toString());
	}
	return result.toString();
    }
}

/**
 * Divide two integers without using multiplication, division and mod operator.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
	long a=Math.abs((long)dividend);
	long b=Math.abs((long)divisor);
	int result=0;
	while(a>=b){
	    long c=b;
	    for(int i=0;a>=c;i++,c<<=1){
		a-=c;
		result+=1<<i;
	    }
	}
	if((dividend>0&&divisor>0)||(dividend<0&&divisor<0)){
	    return result;
	}else{
	    return -result;
	}
    }
}

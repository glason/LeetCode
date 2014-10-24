/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 *
 */
public class Solution {
    public int singleNumber(int[] A) {
	int result=0;
	int stage=1;
	int sign=0;
	boolean flag=true;
	while(flag){
	    flag=false;
	    int digit=0;
	    for(int i=0;i<A.length;i++){
		if(stage==1&&A[i]<0){
		    A[i]*=-1;
		    sign+=1;
		}
		digit+=A[i]%2;
		A[i]/=2;
		if(A[i]!=0){
		    flag=true;
		}
	    }
	    result+=digit%3*stage;
	    stage*=2;
	}
	sign=sign%3;
	if(sign==1){
	    result*=-1;
	}
	return result;
    }
}
public class Solution {
    public int singleNumber(int[] A) {
	int three=0,two=0,one=0;
	for(int a:A){
	    three=two&a;//three times;
	    two|=one&a;//two times;
	    one|=a;//one time;
	    two&=~three;//exclude three times
	    one&=~three;//exclude three times
	}
	return one;
    }
}

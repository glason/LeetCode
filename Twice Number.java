/**
 * 有一个整形数组包含4k+2个整数，其中有k个整数出现了4次，另外一个整数出现了2次。写一个函数，找到那个只出现两次的整数。
 * 要求时间复杂度和空间复杂度尽可能低，使用C++或Java均可。
 */
public class Solution{
    public int getTwice(int[] A){
	int factor=1;
	int result=0;
	boolean conti=true;
	while(conti){
	    conti=false;
	    int sum=0;
	    for(int i=0;i<A.lenght;i++){
		sum+=A[i]%2;
		A[i]/=2;
		if(A[i]>0){
		    conti=true;
		}
	    }
	    result+=sum%4/2*factor;
	    factor*=2;
	}
	return result;
    }
}

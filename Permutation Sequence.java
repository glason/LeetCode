/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class Solution {
    public String getPermutation(int n, int k) {
	StringBuilder sb = new StringBuilder();
	boolean[] taken = new boolean[n];
	int per = 1;
	for (int i = 1; i <= n; i++) {
	    per *= i;
	}
	for (int i = n; i > 0; i--) {
	    per /= i;
	    int sum = 0, j = 1;
	    while (j <= n) {
		sum += per;
		if (sum >= k) {
		    break;
		}
		j++;
	    }
	    sb.append(getKth(taken, j));
	    k = k + per - sum;
	    if (k == 0) {
		for (int t = 0; t < taken.length; t++) {
		    if (!taken[t]) {
			sb.append((char) (t + '1'));
		    }
		}
		break;
	    }
	}
	return sb.toString();
    }
    private char getKth(boolean[] taken, int j) {
	int c = 0;
	for (int i = 0; i < taken.length; i++) {
	    if (!taken[i]) {
		c++;
		if (c == j) {
		    taken[i] = true;
		    return (char) (i + '1');
		}
	    }
	}
	return '0';
    }
}
public class Solution {
    public String getPermutation(int n, int k) {
	k=k-1;
	int count=1;
	StringBuilder sb=new StringBuilder();
	List<Integer> nums=new ArrayList<>();
	for(int i=1;i<=n;i++){
	    nums.add(i);
	    count*=i;
	}
	for(int i=n;i>=1;i--){
	    count/=i;
	    int index=k/count;
	    k=k%count;
	    sb.append((char)(nums.get(index)+'0'));
	    nums.remove(index);
	}
	return sb.toString();
    }
}

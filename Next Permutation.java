/**
 * generate next permutation
 */
public class Solution {
    public boolean nextPermutation(int[] num) {
	int n = num.length;
	int descStart = 0;
	for (int i = n - 1; i > 0; i--) {
	    if (num[i] > num[i - 1]) {
		descStart = i;
		break;
	    }
	}
	if (descStart == 0) {
	    return false;
	}
	for (int i = n - 1; i >= descStart; i--) {
	    if (num[i] > num[descStart - 1]) {
		swap(num, i, descStart - 1);
		break;
	    }
	}
	reverse(num, descStart, n - 1);
	return true;
    }

    private void swap(int[] num, int i, int j) {
	int tmp = num[i];
	num[i] = num[j];
	num[j] = tmp;
    }

    private void reverse(int[] num, int s, int e) {
	for (; s < e; s++, e--) {
	    swap(num, s, e);
	}
    }
}

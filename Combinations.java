/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
	if (n < 1 || k < 1 || n < k) {
	    return null;
	}
	int init = (1 << k) - 1;
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	while (true) {
	    result.add(getList(n, init));
	    int i = 0, mask = 1;
	    for (; i < n; i++) {
		if ((init & mask) > 0) {
		    break;
		}
		mask = mask << 1;
	    }
	    for (; i < n; i++) {
		if ((init & mask) == 0) {
		    break;
		}
		mask = mask << 1;
	    }
	    if (i == n) {
		break;
	    }
	    init = init | mask;
	    init = init ^ (mask >> 1);
	    int right = init & (mask - 1);
	    init = init & (~(mask - 1));
	    int j = i - 1;
	    while ((right & 1) != 1 && j >= 0) {
		right = right >> 1;
		j--;
	    }
	    init = init | right;
	}
	return result;
    }
    private List<Integer> getList(int n, int v) {
	List<Integer> list = new ArrayList<Integer>();
	for (int i = 1, mask = 1; i <= n; i++) {
	    if ((v & mask) > 0) {
		list.add(i);
	    }
	    mask = mask << 1;
	}
	return list;
    }
}

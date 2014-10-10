/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 */
public class Solution {
    public int sqrt(int x) {
	double root=1.0;
	for(int i=0;i<100;i++){
	    root=(root+x/root)/2.0;
	}
	return (int)root;
    }
}

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
/**
 *
 *  * Definition for an interval.
 *
 *   * public class Interval {
 *
 *    *     int start;
 *
 *     *     int end;
 *
 *      *     Interval() { start = 0; end = 0; }
 *
 *       *     Interval(int s, int e) { start = s; end = e; }
 *
 *        * }
 *
 *         */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	Interval next=null,cur=null;
	List<Interval> result=new ArrayList<>();
	int i=0,size=intervals.size();
	boolean used=false;
	while(i<size){
	    Interval t=intervals.get(i);
	    if(used||t.start<newInterval.start){
		next=t;
		i++;
	    }else{
		next=newInterval;
		used=true;
	    }
	    if(cur==null||next.start>cur.end){
		cur=next;
		result.add(cur);
	    }else{
		cur.end=Math.max(cur.end,next.end);
	    }
	}
	if(!used){
	    if(cur==null||cur.end<newInterval.start){
		result.add(newInterval);
	    }else{
		cur.end=Math.max(cur.end,newInterval.end);
	    }
	}
	return result;
    }
}

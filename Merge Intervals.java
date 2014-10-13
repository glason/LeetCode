/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
/**
 *
 *  * Definition for an interval.
 *
 *  public class Interval {
 *
 *    int start;
 *
 *    int end;
 *
 *    Interval() { start = 0; end = 0; }
 *
 *    Interval(int s, int e) { start = s; end = e; }
 *
 *   }
 *
 *         */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
	if(intervals==null){
	    return null;
	}
	Map<Integer,Integer> map=new HashMap<>();
	List<Interval> result=new ArrayList<Interval>();
	int[] starts=new int[intervals.size()];
	int index=0;
	for(Interval interval:intervals){
	    int end=interval.start;
	    if(map.containsKey(interval.start)){
		end=map.get(interval.start);
	    }
	    map.put(interval.start,Math.max(end,interval.end));
	    starts[index++]=interval.start;
	}
	Arrays.sort(starts);
	for(int i=0;i<index;i++){
	    int start=starts[i];
	    int end=map.get(start);
	    for(i++;i<index&&starts[i]<=end;i++){
		end=Math.max(end,map.get(starts[i]));
	    }
	    i--;
	    result.add(new Interval(start,end));
	}
	return result;
    }
}
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
	Collections.sort(intervals,new Comparator<Interval>(){
	    public int compare(Interval a,Interval b){
		return a.start-b.start;
	    }
	});
	List<Interval> result=new ArrayList<Interval>();
	Interval cur=null;
	for(Interval i:intervals){
	    if(cur==null||cur.end<i.start){
		cur=new Interval(i.start,i.end);
		result.add(cur);
	    }else{
		cur.end=Math.max(cur.end,i.end);
	    }
	}
	return result;
    }
}

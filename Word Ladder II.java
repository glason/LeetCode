/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 *
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * Note:
 *      All words have the same length.
 *     All words contain only lowercase alphabetic characters.
 */
public class Solution {
    static class Trace {
	String word;
	Trace pre;
	Trace(String w) {
	    word = w;
	    pre = null;
	}
	Trace(String w, Trace t) {
	    word = w;
	    pre = t;
	}
    }
    public List<List<String>> findLadders(String start, String end,
	    Set<String> dict) {
	List<List<String>> result = new ArrayList<>();
	Queue<Trace> trace = new LinkedList<>();
	Queue<String> cur = new LinkedList<>();
	List<String> next = new ArrayList<>();
	dict.add(end);
	next.add(start);
	trace.offer(new Trace(start));
	while (!cur.isEmpty() || !next.isEmpty()) {
	    if (cur.isEmpty()) {
		if (next.contains(end)) {
		    break;
		} else {
		    for (String s : next) {
			dict.remove(s);
		    }
		    cur.addAll(next);
		    next.clear();
		}
	    }
	    String s = cur.poll();
	    Trace t = trace.poll();
	    char[] c = s.toCharArray();
	    for (int i = 0; i < c.length; i++) {
		char oc = c[i];
		for (char j = 'a'; j <= 'z'; j++) {
		    if (j != oc) {
			c[i] = j;
			String ns = new String(c);
			if (dict.contains(ns)) {
			    next.add(ns);
			    Trace nt = new Trace(ns, t);
			    if (ns.equals(end)) {
				buildList(result, nt);
			    }
			    trace.offer(nt);
			}
		    }
		}
		c[i] = oc;
	    }
	}
	return result;
    }
    private void buildList(List<List<String>> result, Trace t) {
	LinkedList<String> list = new LinkedList<>();
	while (t != null) {
	    list.addFirst(t.word);
	    t = t.pre;
	}
	result.add(list);
    }
}

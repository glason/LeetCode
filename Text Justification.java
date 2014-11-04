/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 *
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *       "example  of text",
 *          "justification.  "
 *          ]
 *          Note: Each word is guaranteed not to exceed L in length.
 */
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
	List<String> result = new ArrayList<>();
	dfs(result, 0, words, L);
	return result;
    }

    private void dfs(List<String> result, int start, String[] words, int L) {
	int len = words.length;
	if (start == len) {
	    return;
	}
	int wc = 0, cc = 0;
	for (int i = start; i < len; i++) {
	    wc++;
	    cc += words[i].length();
	    if (cc + wc - 1 > L) {
		break;
	    }
	}
	StringBuilder sb = new StringBuilder();
	if (cc + wc - 1 > L) {
	    wc--;
	    cc -= words[start + wc].length();
	    for (int i = start, sc = L - cc; i < start + wc; i++) {
		sb.append(words[i]);
		double divid = wc - 1 - i + start;
		int space = divid == 0 ? 0 : (int) Math.ceil(sc / divid);
		for (int j = 0; j < space; j++) {
		    sb.append(" ");
		}
		sc -= space;
	    }
	    while(sb.length()<L){
		sb.append(" ");
	    }
	} else {
	    for (int i = start; i < start + wc; i++) {
		sb.append(words[i]);
		if (sb.length() < L) {
		    sb.append(" ");
		}
	    }
	    while(sb.length()<L){
		sb.append(" ");
	    }
	}
	result.add(sb.toString());
	dfs(result, start + wc, words, L);
    }
}

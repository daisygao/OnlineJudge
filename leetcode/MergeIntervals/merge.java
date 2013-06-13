/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Collections.sort(intervals, new Comparator<Interval>() {
		public int compare(Interval v1, Interval v2) {
		    return v1.start  - v2.start;
		}
	    });
        ArrayList<Interval> res = new ArrayList<Interval>();
        for (Interval v : intervals) {
            if (res.size() == 0) res.add(v);
            Interval last = res.get(res.size() - 1);
            if (overlap(last, v)) last.end = Math.max(last.end, v.end);
            else res.add(v);
        }
        return res;
    }
    private boolean overlap(Interval v1, Interval v2) {
        return !(v1.end < v2.start || v2.end < v1.start);
    }
}
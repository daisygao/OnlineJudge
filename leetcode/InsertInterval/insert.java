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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res = new ArrayList<Interval>();
        for (Interval interval : intervals) {
            if (newInterval == null) res.add(interval);
            else if (overlap(interval, newInterval)) {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            } else if (interval.start > newInterval.end) {
                res.add(new Interval(newInterval.start, newInterval.end));
                newInterval = null;
                res.add(interval);                
            } else {
                res.add(interval);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res;
    }
    boolean overlap(Interval A, Interval B) {
	return !(A.end < B.start || B.end < A.start);
    }
}
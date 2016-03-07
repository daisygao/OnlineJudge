/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> merge(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const Interval &a, const Interval &b) -> bool {
            return a.start == b.start ? a.end < b.end : a.start < b.start;
        });
        vector<Interval> ans;
        for (auto x : intervals) {
            if (ans.size() == 0 || ans.back().end < x.start) {
                ans.push_back(x);
            } else {
                ans.back().end = max(ans.back().end, x.end);
            }
        }
        return ans;
    }
};

class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(), citations.end());
        int h = 0, size = citations.size();
        for (int i = size - 1; i >= 0; i--) {
            if (citations[i] <= h) return h;
            h = max(h, min(citations[i], size - i));
        }
        return h;
    }
};

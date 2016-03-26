class Solution {
public:
    int hIndex(vector<int>& citations) {
        int size = citations.size(), left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= size - mid) right = mid - 1;
            else left = mid + 1;
        }
        return size - left;
    }
};

// Forward declaration of isBadVersion API.
bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (isBadVersion(m)) j = m;
            else i = m + 1;
        }
        return j;
    }
};

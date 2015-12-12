class Solution {
public:
    int hammingWeight(uint32_t n) {
        int w = 0;
        while (n) {
            n &= (n - 1);
            w++;
        }
        return w;
    }
};

class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        int x = 0, t = 32;
        while (t-- > 0) {
            x = (x << 1) + (n & 1);
            n >>= 1;
        }
        return x;
    }
};

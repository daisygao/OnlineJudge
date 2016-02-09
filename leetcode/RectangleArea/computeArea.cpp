class Solution {
public:
    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x = max(A, E), m = min(C, G), y = max(B, F), n = min(D, H);
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        if (x > m || y > n) return area;
        return area - (m - x) * (n - y);
    }
};

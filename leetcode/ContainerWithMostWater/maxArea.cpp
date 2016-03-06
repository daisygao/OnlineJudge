class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0, right = height.size() - 1, area = 0;
        while (left < right) {
            int minH = min(height[left], height[right]);
            area = max(area, (right - left) * minH);
            while (left < right && height[left] <= minH) left++;
            while (right > left && height[right] <= minH) right--;
        }
        return area;
    }
};

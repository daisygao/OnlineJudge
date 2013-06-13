public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = height.length;
        if (len < 2) return 0;
        int left = 0, right = len - 1, area = 0;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            area = Math.max(area, (right - left) * min);
            if (height[left] < height[right]) {
                while (++left < right && height[left] < min);
            } else {
                while (--right > left && height[right] < min);
            }
        }
        return area;
    }
}
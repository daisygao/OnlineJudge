public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = height.length, max = 0;
        int left[] = new int[len];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            while (!st.empty() && height[st.peek()] >= height[i]) st.pop();
            left[i] = st.empty() ? 0 : st.peek() + 1;
            st.push(i);
        }
        st.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!st.empty() && height[st.peek()] >= height[i]) st.pop();
            int right = st.empty() ? len : st.peek();
            max = Math.max(max, (right - left[i]) * height[i]);
            st.push(i);
        }
        return max;
    }
}
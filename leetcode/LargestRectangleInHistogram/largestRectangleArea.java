public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = height.length, left[] = new int[len], right = 0, ans = 0;
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            while (!st.empty() && height[st.peek()] >= height[i]) st.pop();
            left[i] = st.empty() ? 0 : st.peek() + 1;
            st.push(i);
        }
        st.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!st.empty() && height[st.peek()] >= height[i]) st.pop();
            right = st.empty() ? len : st.peek();
            st.push(i);
            ans = Math.max(ans, (right - left[i]) * height[i]);
        }
        return ans;
    }
}
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int height = matrix.length;
        if (height == 0) return 0;
        int width = matrix[0].length, hist[] = new int[width], left[] = new int[width], ans = 0;
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < height; i++) {
            st.clear();
            for (int j = 0; j < width; j++) {
                hist[j] = matrix[i][j] == '0' ? 0 : (hist[j] + 1);
                while (!st.empty() && hist[st.peek()] >= hist[j]) st.pop();
                left[j] = st.empty() ? 0 : (st.peek() + 1);
                st.push(j);
            }
            st.clear();
            int right = 0;
            for (int j = width - 1; j >= 0; j--) {
                while (!st.empty() && hist[st.peek()] >= hist[j]) st.pop();
                right = st.empty() ? width : st.peek();
                st.push(j);
                ans = Math.max(ans, hist[j] * (right - left[j]));
            }
        }
        return ans;
    }
}
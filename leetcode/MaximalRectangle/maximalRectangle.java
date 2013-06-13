public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int height = matrix.length;
        if (height == 0) return 0;
        int width = matrix[0].length, max = 0;
        int col[] = new int[width], left[] = new int[width], right[] = new int[width];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < height; i++) {
            st.clear();
            for (int j = 0; j < width; j++) {
                col[j] = matrix[i][j] == '0' ? 0 :
                    ((i - 1 >= 0 ? col[j] : 0) + 1);
                while (!st.empty() && col[st.peek()] >= col[j]) {
                    st.pop();
                }
                left[j] = st.empty() ? 0 : st.peek() + 1;
                st.push(j);
            }
            st.clear();
            for (int j = width - 1; j >= 0; j--) {
                while (!st.empty() && col[st.peek()] >= col[j]) {
                    st.pop();
                }
                right[j] = st.empty() ? width - 1 : st.peek() - 1;
                st.push(j);
                max = Math.max(max, col[j] * (right[j] - left[j] + 1));
            }
        }
        return max;
    }
}
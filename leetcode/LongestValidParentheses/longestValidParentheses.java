public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length(), max = 0, sol[] = new int[len];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (!st.empty()) {
                    int start = st.pop();
                    sol[i] = i - start + 1;
                    if (start != 0) sol[i] += sol[start - 1];
                    max = Math.max(max, sol[i]);
                } 
            }
        }
        return max;
    }
}
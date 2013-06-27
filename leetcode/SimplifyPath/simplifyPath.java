public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String parts[] = path.split("/");
        Stack<String> st = new Stack<String>();
        for (String s : parts) {
            if (s.equals("..")) {
                if (!st.empty()) st.pop();
            } else if (s.equals(".") || s.equals("")) {
                // do nothing
            } else {
                st.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (st.empty()) sb.append("/");
        while (!st.empty()) {
            sb.insert(0, "/" + st.pop());
        }
        return sb.toString();
    }
}
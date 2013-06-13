public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String arr[] = path.split("/");
        Stack<String> st = new Stack<String>();
        for (String s : arr) {
            if (s.equals(".") || s.isEmpty()) {
                //
            } else if (s.equals("..")) {
                if (st.size() > 0) st.pop();
            } else {
                st.push(s);
            }
        }
        if (st.empty()) return "/";
        StringBuilder spath = new StringBuilder();
        while (!st.empty()) {
            spath.insert(0, "/" + st.pop());
        }
        return spath.toString();
    }
}
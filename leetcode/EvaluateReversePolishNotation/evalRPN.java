public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        for (String s : tokens) {
            try {
                st.push(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                int b = st.pop(), a = st.pop(), c = 0;
                switch (s) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b; 
                        break;
                    case "*": 
                        c = a * b;
                        break;
                    case "/":
                        c = a / b;
                        break;
                    default:
                        break;
                }
                st.push(c);
            }
        }
        return st.peek();
    }
}
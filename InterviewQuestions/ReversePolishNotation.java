public double rpn(List<String> ops) throws IllegalArgumentException, ArithmeticException {
	Stack<Double> st = new Stack<Double>();
	double x;
	for (String s : ops) {
		switch (s.charAt(0)) {
			case '+':
			st.push(st.pop() + st.pop());
			break;
			case '-':
			x = st.pop();
			st.push(st.pop() - x);
			break;
			case '*':
			st.push(st.pop() * st.pop());
			break;
			case '/':
			x = st.pop();
			if (x != 0) {
				st.push(st.pop() / x);
			} else {
				throw new ArithmeticException("divided by " + x);
			}
			break;
			case '!':
			st.push(factorial(st.pop()));
			break;
			default:
			st.push(Double.valueOf(s));
			break;
		}
	}
	return st.pop();
}
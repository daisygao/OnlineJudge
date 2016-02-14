class MinStack {
    struct Element {
        int m_val;
        int m_min;
        Element(int val, int min): m_val(val), m_min(min) {}
    };
public:
    stack<Element> st;
    void push(int x) {
        st.push(Element(x, st.empty() ? x : min(x, st.top().m_min)));
    }

    void pop() {
        st.pop();
    }

    int top() {
        return st.top().m_val;
    }

    int getMin() {
        return st.top().m_min;
    }
};

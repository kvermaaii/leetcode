class MinStack {
    Stack<Integer> stk;
    int Min;

    public MinStack() {
        stk = new Stack<>();
        Min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stk.push(Min); 
        Min = Math.min(Min, val); 
        stk.push(val);
    }

    public void pop() {
        if (!stk.isEmpty()) {
            stk.pop(); 
            Min = stk.pop();
        }
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return Min; 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

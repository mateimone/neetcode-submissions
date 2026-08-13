class MinStack {
    Stack<Integer> mins;
    Stack<Integer> stack;

    public MinStack() {
        this.mins = new Stack<>();
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if (this.mins.empty() || val <= this.mins.peek()) {
            this.mins.push(val);
        }
    }
    
    public void pop() {
        int rmv = this.stack.pop();
        if (rmv == this.mins.peek()) {
            this.mins.pop();
        }
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.mins.peek();
    }
}

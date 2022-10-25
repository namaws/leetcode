class MinStack {
    // main stack
    Stack <Integer> mainStack;
    // stack to record min value
    Stack <int[]> minStack;
    public MinStack() {
        mainStack = new Stack<Integer>();
        minStack = new Stack<int[]>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty() || val < minStack.peek()[0]) {
            minStack.push(new int[]{val, 1});
        }

        else if(val == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
        
    }
    
    public void pop() {
        if(mainStack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }
        
        if(minStack.peek()[1] == 0) {
            minStack.pop();
        }
        mainStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
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
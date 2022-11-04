class MinStack {
    List<Integer> list;
    Stack<Integer> stack;
    
    public MinStack() {
        list = new ArrayList();
        stack = new Stack();
    }
    
    public void push(int val) {
        list.add(val);
        if(stack.isEmpty() || val <= stack.peek()) {
            stack.push(val);
        }
    }
    
    public void pop() {
        if(stack.peek().equals(list.get(list.size()-1))) {
            stack.pop();
        }
        list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return stack.peek();
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
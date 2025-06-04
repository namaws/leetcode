class MinStack {
    List<Integer> list;
    Stack<Integer> stack;

    public MinStack() {
        list = new ArrayList();
        stack = new Stack();
    }
    
    public void push(int val) {
        if(stack.empty() || val <= stack.peek()) {
            stack.push(val);
        }
        list.add(val);
    }
    
    public void pop() {
        int val = list.get(list.size()-1);
        /**
        Integer Caching and == Comparison
        In Java, when comparing two Integer objects using ==, you’re comparing object references, not values, unless they're in the cached range [-128 to 127].

        list.get(...) and stack.peek() both return Integer objects.
        So list.get(...) == stack.peek() might return false even if the values are the same if they are not the same object.
 */
        if(list.get(list.size()-1).equals(stack.peek())) {
            System.out.println("pop: "+stack.pop());
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
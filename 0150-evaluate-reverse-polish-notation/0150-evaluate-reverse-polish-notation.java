class Solution {
    public int evalRPN(String[] tokens) {
        //use stack to give track of current value
        Stack<Integer> stack = new Stack();
        Set<String> operations = Set.of("+", "-", "*", "/");
        
        for(int i=0; i<tokens.length; i++) {
            if(stack.size() >=2 && operations.contains(tokens[i])) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                
                if(tokens[i].equals("+"))
                    stack.add(val1+val2);
                else if(tokens[i].equals("-"))
                    stack.add(val1-val2);
                else if(tokens[i].equals("*"))
                    stack.add(val1*val2);
                else
                    stack.add(val1/val2);
            }
            else
                stack.add(Integer.valueOf(tokens[i]));
        }
        
        return stack.pop();
    }
}
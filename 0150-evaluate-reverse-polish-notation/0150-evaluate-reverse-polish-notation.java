class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i=0; i<tokens.length; i++) {
            if(tokens[i].equals("+") && stack.size() >=2 ) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1+val2);
            }
            else if(tokens[i].equals("-") && stack.size() >= 2) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2-val1);
            }
            else if(tokens[i].equals("*") && stack.size() >= 2) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1*val2);
            }
            else if(tokens[i].equals("/") && stack.size() >= 2) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2/val1);
            }
            else
                stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.pop();
    }
}
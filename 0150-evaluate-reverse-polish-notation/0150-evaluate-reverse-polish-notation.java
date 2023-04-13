class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String token: tokens) {
            //digit
            if(token.length()>1 || Character.isDigit(token.charAt(0)))
                stack.add(Integer.valueOf(token));
            else {
                if(token.equals("*")) {
                    int second = stack.pop();
                    int first = stack.pop();
                    int temp = first*second;
                    stack.add(temp);
                }
                else if(token.equals("/")) {
                    int second = stack.pop();
                    int first = stack.pop();
                    int temp = first/second;
                    stack.add(temp);
                }
                else if(token.equals("-")) {
                    int second = stack.pop();
                    int first = stack.pop();
                    int temp = first-second;
                    stack.add(temp);
                }
                else {
                    int second = stack.pop();
                    int first = stack.pop();
                    int temp = first+second;
                    stack.add(temp);
                }
            }
        }
        return stack.isEmpty()? 0: stack.pop();
    }
}
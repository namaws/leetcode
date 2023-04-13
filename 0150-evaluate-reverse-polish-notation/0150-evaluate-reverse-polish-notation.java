class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Set<String> operations = Set.of("+","-","*","/");
        
        for(String token: tokens) {
            //check if stack has at least two -> in order to do valid operation
            if(stack.size()>=2 && operations.contains(token)) {
                int second = stack.pop();
                int first = stack.pop();
                int temp = 0;
                
                switch(token) {
                        case "+":
                            temp = first+second;
                            break;
                        case "-":
                            temp = first-second;
                            break;
                        case "*":
                            temp = first*second;
                            break;
                        case "/":
                            temp = first/second;
                            break;
                }
                stack.push(temp);
            }
            else
                stack.push(Integer.valueOf(token));
        }
        return stack.pop();
    }
}
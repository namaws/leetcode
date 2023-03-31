class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        Set<String> operation = Set.of( "+", "-", "*", "/" );
        
        for( String s: tokens ) {
            if( stack.size() >= 2 && operation.contains(s) ) {
                
                int first = stack.pop();
                int second = stack.pop();
                int temp = 0;
                
                
/*                if ( s.equals("+") ) temp = second + first; // string not char, so need to use .equals to compare
                else if( s.equals("-") ) temp = second - first;
                else if( s.equals("*") ) temp = second * first;
                else temp = second/first;
*/
                
                switch(s) {
                    case "+":
                        temp = second + first;
                        break;
                        
                    case "-":
                        temp = second - first;
                        break;
                    case "*":
                        temp = second * first;
                        break;
                    case "/":
                        temp = second / first;
                        break;
                }
                
                stack.push(temp);
            }
            
            else
                stack.push(Integer.valueOf(s));
        }
        
        return stack.pop();
        
    }
}

// time O(n)
// space O(n)
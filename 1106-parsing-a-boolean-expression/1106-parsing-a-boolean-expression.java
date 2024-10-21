class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> operator = new Stack();
        Stack<Character> represent = new Stack();
        
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == ',') continue;
            else if(c == '(' || c == 't' || c == 'f')
                represent.push(c);
            else if(c == '!' || c == '&' || c == '|')
                operator.push(c);
            //close parantheses
            else {
                boolean hasTrue = false;
                boolean hasFalse = false;
                while(represent.peek() != '(') {
                    if(represent.peek() == 't')
                        hasTrue = true;
                    else
                        hasFalse = true;
                    represent.pop();
                }
                if(represent.peek() == '(') {
                    represent.pop();
                    char op = operator.pop();
                    if(op == '&') 
                        represent.push(hasFalse? 'f':'t');
                    else if(op == '|')
                        represent.push(hasTrue? 't':'f');
                    else
                        represent.push(hasTrue? 'f': 't');
                    
                }
            }
            
        }
        return represent.peek() == 't';
    }
}
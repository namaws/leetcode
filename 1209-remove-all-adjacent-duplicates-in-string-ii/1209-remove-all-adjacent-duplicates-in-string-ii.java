class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty() || c != stack.peek().key) {
                stack.push(new Pair(c, 1));
            }
            else {
                if(++stack.peek().value == k) {
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()) {
            char c = stack.peek().key;
            int cnt = stack.peek().value;
            stack.pop();
            while(cnt > 0) {
                sb.append(c);
                cnt--;
            }
        }
        return sb.reverse().toString();
    }
}
class Pair {
        char key;
        int value;
        public Pair(char k, int v) {
            this.key = k;
            this.value = v;
        }
    }
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(stack.isEmpty() || s.charAt(i) != stack.peek().ch) {
                stack.push(new Pair(s.charAt(i), 1));
            } else {
                if(++ stack.peek().cnt == k) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            for(int i=0; i<p.cnt; i++) {
                sb.append(p.ch);
            }
        }
        return sb.reverse().toString();
    }
}

class Pair {
    int cnt;
    char ch;
    public Pair(char ch, int cnt) {
        this.ch = ch;
        this.cnt = cnt;
    }
}
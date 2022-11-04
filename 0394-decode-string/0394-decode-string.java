class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack();
        Stack<String> decoding = new Stack();
        String res = "";
        int idx = 0;
        while(idx <s.length()) {
            char c = s.charAt(idx);
            if(Character.isDigit(c)) {
                int num = 0;
                while(Character.isDigit(s.charAt(idx))) {
                    num = num*10 + (s.charAt(idx++)-'0');
                }
                count.push(num);
            }
            
            else if(c == '[') {
                decoding.push(res);
                res = "";
                idx++;
            }
            
            else if(c == ']') {
                int repeat = count.pop();
                StringBuilder temp = new StringBuilder(decoding.pop());
                for(int i=0; i<repeat; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            
            else {
                res += c;
                idx++;
            }
        }
        
        return res;
    }
}
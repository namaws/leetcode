class Solution {
    public String decodeString(String s) {
        // record square brackets
        Stack<Integer> digit = new Stack<>();
        Stack<String> string = new Stack<>();
        String res = "";
        int idx = 0;
        while(idx < s.length()) {
            char c = s.charAt(idx);
            //CASE 1 number
            if(Character.isDigit(c)) {
                int count = 0;
                while(Character.isDigit(s.charAt(idx))) {
                    count = 10*count + (s.charAt(idx)-'0');
                    idx++;
                }
                digit.push(count);
            }
            
            //CASE 2 [
            else if(c == '[') {
                string.push(res);
                res = "";
                idx++;
            }
            
            //CASE 3 ]
            else if(c == ']') {
                StringBuilder temp = new StringBuilder(string.pop());
                int repeat = digit.pop();
                for(int i=0; i<repeat; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}

class Solution {
    public String decodeString(String s) {
        //3[a2[c]] nested encoded string
        // decode the innermost string and continue in an outward direction until the entire string is decoded
        Stack<Integer> count = new Stack();
        Stack<String> decoding = new Stack();
        int idx = 0;
        String res = "";
        while(idx <s.length()) {
            if(Character.isDigit(s.charAt(idx))) {
                int num = 0;
                while(Character.isDigit(s.charAt(idx))) {
                    num = num*10 + (s.charAt(idx)-'0');
                    idx++;
                }
                count.push(num); 
            }
            
            else if(s.charAt(idx) == '[') {
                decoding.push(res);
                res = "";
                idx++;
            }
            
            else if(s.charAt(idx) == ']') {
                int repeat = count.pop();
                StringBuilder sb = new StringBuilder(decoding.pop());
                for(int i=0; i<repeat; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            }
            else {
                res += s.charAt(idx);
                idx++;
            }
        }
        return res;
    }
}
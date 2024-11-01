class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        if(len == 0) return 0;
        
        //step 1. remove space
        int idx = 0;
        while(idx < len && s.charAt(idx) == ' ') {
            idx++;
        }
        
        if(idx == len) return 0;
        //step 2. check sign
        boolean isNeg = false;
        if(s.charAt(idx) == '+' || s.charAt(idx) == '-') {
            isNeg = s.charAt(idx++) == '-'? true:false;
        }
        
        int total = 0;
        //step 3. conversion
        while(idx < len) {
            int digit = s.charAt(idx)-'0';
            if(digit < 0 || digit > 9) break;
            
            //if need to round up
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE%10 < digit)
                return isNeg == true? Integer.MIN_VALUE: Integer.MAX_VALUE;
            total = 10*total+digit;
            idx++;   
        }
        
        return isNeg == true? total*-1:total;
    }
}
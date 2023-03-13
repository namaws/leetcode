class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        if(s.length() == 0 || s.length() == 1) return true;
        boolean hasAlphabet = false;
        while(left <= right) {
            while(left < s.length() && !Character.isLetterOrDigit(s.charAt(left))) 
                left++;
            while(right >= 0 && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if(left >= s.length() || right < 0) 
                return hasAlphabet? false:true;
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            hasAlphabet = true;
            left++;
            right--;
        }
        return true;
    }
}
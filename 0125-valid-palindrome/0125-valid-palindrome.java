class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) return true;
        int left = 0;
        int right = s.length()-1;
        while(left <= right) {
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            
            char cLeft = Character.toLowerCase(s.charAt(left));
            char cRight = Character.toLowerCase(s.charAt(right));
            if(cLeft != cRight)
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
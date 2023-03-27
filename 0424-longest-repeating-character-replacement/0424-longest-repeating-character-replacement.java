class Solution {
    public int characterReplacement(String s, int k) {
        //as only consists of uppercase english letters
        int[] count = new int[26];
        //left pointer to record the start index of the longest repeating character 
        int left = 0;
        //counting the current most frequent character in the sliding window
        int maxCount = 0, maxLength = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            //check the current most frequently character in the sliding window
            maxCount = Math.max(maxCount, ++count[c-'A']);
            //if the character inside the sliding window that needs to be replace is bigger than k
            // i-left+1 (current window length) - maxCount (current most freqency) = the number of characters that need to be replace
            while(i-left+1-maxCount > k) {
                //move the window one step forward, therefore, deduct the count of that character
                count[s.charAt(left)-'A']--;
                //move the windew one step forward
                left++;
            }
            maxLength = Math.max(maxLength, i-left+1);
        }
        
        return maxLength;
    }
}
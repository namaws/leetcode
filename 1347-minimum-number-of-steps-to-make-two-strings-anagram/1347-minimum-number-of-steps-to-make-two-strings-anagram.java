class Solution {
    public int minSteps(String s, String t) {
        // character 
        int[] count = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            ++count[c1-'a'];
            --count[c2-'a'];
        }
        int cnt = 0;
        // here only calculate one side
        // if count tArr[i] - sArr[i], would count the twice of difference
        for (int step : count) {
            if (step > 0) {
                cnt += step;
            }
        }
        
        return cnt;
    }
}
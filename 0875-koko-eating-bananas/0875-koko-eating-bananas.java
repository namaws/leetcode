class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for(int i=0; i<piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        
        while(left < right) {
            int mid = (left+right)/2;
            int hrs = 0;
            
            //iterate through the piles, and find the hours needed to finish
            for(int pile: piles) {
                hrs += pile%mid == 0 ? pile/mid:pile/mid+1;
            }
            
            if(hrs > h) {
                left = mid+1;
            }
            //because is hrs <= h, therefore, right = mid instead of mid+1
            else
                right = mid;
        }
        return right;
    }
}
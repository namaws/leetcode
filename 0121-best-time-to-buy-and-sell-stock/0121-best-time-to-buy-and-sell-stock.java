class Solution {
    public int maxProfit(int[] prices) {
        int currMin = prices[0];
        int totalMax = 0;
        for(int i=1; i<prices.length; i++) {
            totalMax = Math.max(prices[i]-currMin,totalMax);
            currMin = Math.min(currMin, prices[i]);
                
        }
        return totalMax;
    }
}
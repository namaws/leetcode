class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int left = 0;
        int right = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i]<prices[left]) {
                left = i;
            }
            
            else {
                result = Math.max(result, prices[i]-prices[left]);
            }
        }

        return result;
    }
}
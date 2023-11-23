class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int price: prices) {
            min = Math.min(min, price);
            profit = Math.max(price-min, profit);
        }
        return profit;
    }
}
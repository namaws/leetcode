class Solution {
    int sum;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0) return 0;
        sum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length+1][sum*2+1];
        for (int[] row: dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return helper(nums, 0, 0, dp, target);
    }

    public int helper(int[] nums, int idx, int total, int[][] dp, int target) {
        if(idx == nums.length) {
            return total == target ? 1:0;
        }
        if(dp[idx][total+sum] != Integer.MIN_VALUE)
            return dp[idx][total+sum];

        dp[idx][total+sum] = helper(nums, idx+1, total+nums[idx], dp, target) + helper(nums, idx+1, total-nums[idx], dp, target);
        return dp[idx][total+sum];
    }
}
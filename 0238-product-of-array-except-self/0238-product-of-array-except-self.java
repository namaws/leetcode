class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        //using prefix to record the product of numbers before hand
        //for index = 0, there is no prefix, hence, the prefix is longer
        int[] prefix = new int[n];
        prefix[0] = 1;
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        
        int postfix = 1;
        for(int i=n-1; i>=0; i--) {
            prefix[i] *= postfix;
            postfix *= nums[i];
        }
        
        return prefix;
    }
}
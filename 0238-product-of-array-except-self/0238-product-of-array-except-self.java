class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for(int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        int postfix = 1;
        for(int i=nums.length-1; i>0; i--) {
            prefix[i] *= postfix;
            postfix *= nums[i];
        }
        prefix[0] *= postfix;
        return prefix;
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = 0;
        int left = 0;
        int curr = 0;
        if(target == 0 || nums.length == 0) return 0;
        for(int i=0; i<nums.length; i++) {
            curr += nums[i];
            while(curr >= target) {
                if(len == 0 || len > i-left+1)
                    len = i-left+1;
                curr -= nums[left];
                left++;
            }
        }
        return len;
    }
}
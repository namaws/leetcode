class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        Arrays.sort(nums);
        
        int currentLen = 1;
        int bestLen = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                if(nums[i] == nums[i-1]+1) 
                    currentLen++;
                else {
                    bestLen = Math.max(bestLen, currentLen);
                    currentLen = 1;
                }
            }
        }
        return Math.max(bestLen, currentLen);
    }
}
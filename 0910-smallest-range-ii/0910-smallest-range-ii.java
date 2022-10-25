class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = 0;
        int min = 0;
        int res = nums[len-1]-nums[0];
        for(int i=0; i<len-1; i++) {
            max = Math.max(nums[len-1]-k, nums[i]+k);
            min = Math.min(nums[0]+k, nums[i+1]-k);
            res = Math.min(res, max-min);
        }
        return res;
    }
}
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length<3) return 0;
        
        Arrays.sort(nums);
        int cnt = 0;
        for(int i=0; i<nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            int remain = target - nums[i];
            while(left < right) {
                if(remain > nums[left]+nums[right]) {
                    cnt += right-left;
                    left++;
                }
                else
                    right--;
            } 
        }
        return cnt;
    }
}
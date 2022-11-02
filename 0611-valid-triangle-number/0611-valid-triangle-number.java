class Solution {
    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        
        for(int i=2; i<nums.length; i++) {
            int left = 0, right = i-1;
            //compare nums[left] ~ nums[right-1] with nums[right] and nums[i]
            while(left<right) {
                if(nums[left] + nums[right] > nums[i]) {
                    result += right-left;
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return result;
    }
}
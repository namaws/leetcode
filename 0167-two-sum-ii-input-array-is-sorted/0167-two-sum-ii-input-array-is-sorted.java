class Solution {
    public int[] twoSum(int[] nums, int target) {
        //using binary search (curr max, curr min) to find the answer
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[2];
        while(left < right) {
            int curr = nums[left]+nums[right];
            if(curr < target) {
                left++;
                continue;
            }
            else if(curr > target) {
                right--;
                continue;
            }
            else {
                result[0] = left+1;
                result[1] = right+1;
                break;
            }
        }
        
        return result;
    }
}
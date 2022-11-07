class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for(int i=0; i<nums.length-2; i++) {
            // skip if duplicate
            if(i== 0 || nums[i] != nums[i-1]) {
                int left = i+1;
                int right = nums.length-1;
                while(left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum < 0) left++;
                    else if(sum > 0) right--;
                    else {
                        List<Integer> curr = new ArrayList();
                        curr.add(nums[i]);
                        curr.add(nums[left++]);
                        curr.add(nums[right--]);
                        result.add(curr);
                        // cuz left already ++, need to compare curr and prev
                        while(left < right && nums[left] == nums[left-1]) left++;
                        while(left < right && nums[right] == nums[right+1]) right--;
                    }
                }
            }
        }
        return result;
    }
}
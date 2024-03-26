class Solution {
    public void rotate(int[] nums, int k) {
        k = check(nums, k);
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    
    private int check(int[] nums, int k) {
        if(k > nums.length) {
            k -= nums.length;
            return k = check(nums, k);
        }
        else
            return k;
            
    }


}
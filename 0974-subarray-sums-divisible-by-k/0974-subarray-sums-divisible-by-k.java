class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int[] map = new int[k];
		map[0] = 1;
        int count = 0, sum = 0;
        for(int i : nums) {
            sum = (sum + i) % k;
            if(sum < 0) sum += k;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map[sum];
            map[sum]++;
        }
        return count;
    }
}
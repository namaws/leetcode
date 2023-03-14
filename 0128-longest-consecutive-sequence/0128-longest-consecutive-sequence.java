class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet();
        int maxCount = 0;
        for(int num:nums) set.add(num);
        for(int num: nums) {
            //looking from the smallest
            if(!set.contains(num-1)) {
                int count = 1;
                while(set.contains(num+1)) {
                    num++;
                    count++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}
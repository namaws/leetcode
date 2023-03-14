class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        int maxCount = 0;
        for(int num: nums) {
            if(!set.contains(num))
                set.add(num);
            int curr = num;
            int count = 1;
            while(set.contains(num+1)) {
                num++;
                count++;
            }
            while(set.contains(curr-1)) {
                curr--;
                count++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
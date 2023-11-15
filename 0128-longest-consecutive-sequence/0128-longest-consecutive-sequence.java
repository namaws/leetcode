class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num: nums)
            set.add(num);
        int len = 0;
        for(int num: nums) {
            if(!set.contains(num-1)) {
                int next = num+1;
                while(set.contains(next)) {
                    next+=1;
                }
                len = Math.max(len, next-num);
            }
        }
        return len;
    }
}
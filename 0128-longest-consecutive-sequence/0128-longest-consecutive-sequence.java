class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num: nums) {
            set.add(num);
        }
        int best = 0;
        for(int num: set) {
            if(!set.contains(num-1)) {
                int y = num+1;
                while(set.contains(y))
                    y+=1;
                best = Math.max(best, y-num);
            }
        }
        
        return best;
    }
}
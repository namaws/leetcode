class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num: nums) {
            set.add(num);
        }
        int best = 0;
        for(int num: set) {
            
            if(!set.contains(num-1)){
                int temp = num+1;
                while(set.contains(temp))
                    temp++;
                best = Math.max(best, temp-num);
            }
        }   
        return best;
    }
}
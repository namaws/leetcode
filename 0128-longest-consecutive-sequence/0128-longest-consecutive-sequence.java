class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num: nums) {
            set.add(num);
        }
        int len = 0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            int i = iterator.next();
            if(!set.contains(i-1)) {
                int next = i+1;
                while(set.contains(next))
                    next++;
                len = Math.max(len, next-i);
            }
        }
        return len;
    }
}
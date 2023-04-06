class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //k,v -> value, frequency
        Map<Integer, Integer> count = new HashMap();
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> count.get(a) - count.get(b));
        int[] result = new int[k];
        for(int i=0; i<nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        
        for(int i: count.keySet()) {
            queue.add(i);
            if(queue.size()>k)
                queue.poll();
        }
        
        for(int i=0; i<k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
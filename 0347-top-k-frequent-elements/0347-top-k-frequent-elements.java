class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //K,V -> nums[i], frequency of nums[i]
        Map<Integer, Integer> count = new HashMap();
        Queue<Integer> q = new PriorityQueue<>((n1, n2) -> count.get(n2)-count.get(n1));
        int[] result = new int[k];
        for(int n: nums) 
            count.put(n, count.getOrDefault(n, 0)+1);
        for(int n: count.keySet()) 
            q.add(n);
        
        for(int i=0; i<k; i++) {
            result[i] = q.poll();
        }
        return result;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //<k, v> -> <value, times>
        Map<Integer,Integer> map = new HashMap();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        int[] result = new int[k];
        for(int key: map.keySet()) {
            pq.add(key);
            if(pq.size()>k) {
                pq.poll();
            }
        }
        
        for(int i=0; i<k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
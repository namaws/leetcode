class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //<k,v> -> <num value, num freq>
        Map<Integer,Integer> count = new HashMap();
        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> count.get(a) - count.get(b));
        int[] result = new int[k];
        for(int i:count.keySet()) {
            pq.add(i);
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
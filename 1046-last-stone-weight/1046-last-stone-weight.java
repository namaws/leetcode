class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));
        for(int i:stones) maxHeap.offer(i);
        while(maxHeap.size()>1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            int result = first-second;
            maxHeap.offer(result);
        }
        return maxHeap.poll();
    }
}
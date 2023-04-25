class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        for(int stone: stones) 
            heap.offer(stone);
        while(heap.size() > 1) {
            heap.offer(heap.poll()-heap.poll());
        }
        return heap.poll();
        // the head of this queue, or null if this queue is empty
        
    }
}
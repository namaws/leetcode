class KthLargest {
    int k;
    PriorityQueue<Integer> heap = new PriorityQueue();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i: nums) add(i);
    }
    
    public int add(int val) {
        if(heap.size() < k) heap.offer(val);
        else if(val > heap.peek()) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
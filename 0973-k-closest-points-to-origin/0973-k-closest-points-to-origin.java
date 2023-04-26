class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare((b[0]*b[0]+b[1]*b[1]),(a[0]*a[0]+a[1]*a[1])));
        for(int[] point: points) {
            if(maxHeap.size() < k) {
                maxHeap.offer(point);
                continue;
            }
            int[] curr = maxHeap.peek();
            int curD = curr[0]*curr[0]+curr[1]*curr[1];
            int pointD = point[0]*point[0]+point[1]*point[1];
            if(pointD < curD) {
                maxHeap.poll();
                maxHeap.offer(point);
            }
        }
        int[][] result = new int[k][2];
        for(int i=0; i<k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
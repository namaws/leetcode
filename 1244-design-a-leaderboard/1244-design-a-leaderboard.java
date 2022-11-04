class Leaderboard {
    //playerId - key, score - value
    private HashMap<Integer, Integer> scores;
    public Leaderboard() {
        scores = new HashMap();
    }
    
    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0)+score);
    }
    
    public int top(int K) {
       
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a - b);
        
        for(int value: scores.values()) {
            heap.offer(value);
            if(heap.size() > K) {
                heap.poll();
            }
        }
        
        int total = 0;
        for(int i=0; i<K; i++) {
            total += heap.poll();
        }
        
        return total;
        
    }
    
    public void reset(int playerId) {
        scores.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
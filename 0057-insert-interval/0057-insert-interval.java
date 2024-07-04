class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list = new ArrayList();
        
        //3 situation
        //1. at the very beginning
        //2. at the very back
        //3. in the middle
        
        int situation = 0;
        
        for(int[] interval: intervals) {
            //newInterval is in the front -> no overlap
            if(newInterval == null || interval[1] < newInterval[0]) {
                list.add(interval);
            }
            
            //newInterval is behind -> don't know if there's an overlap afterwards
            else if(interval[0] > newInterval[1]) {
                list.add(newInterval);
                list.add(interval);
                newInterval = null;
            }
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        
        if(newInterval != null) list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
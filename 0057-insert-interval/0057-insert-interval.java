class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList();
        /**
        1. before current interval
        2. behind current interval
        3. overlap
         */
        for(int[] interval: intervals) {
            //after current interval
            if(newInterval == null || interval[1]<newInterval[0])
                list.add(interval);
            
            //before current interval
            else if(interval[0] > newInterval[1]) {
                list.add(newInterval);
                list.add(interval);
                newInterval = null;
            }

            //overlaping
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if(newInterval != null) list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
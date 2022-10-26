class Solution {
    public int minMeetingRooms(int[][] intervals) {
        /*
        1. sorting based on the start time of each meeting -> custom comparator O(N*logN)
        2. [s1,e1] [s2,e2]
                i.   j
            if(i>j) -> try to find a room for meeting2
            else -> don't need to do anything(cuz it can just use the meeting room after meeting 1 finish)
        
        3. how to find a meeting room?
            using minHeap???
        */
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];
        
        for(int i=0; i<intervals.length; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }        
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int room = 0;
        int endIdx = 0;
        for(int i=0; i<startTime.length; i++) {
            if(startTime[i] < endTime[endIdx]) {
                room ++;
            }
            else {
                endIdx++;
            }
        }
        return room;
    }
}
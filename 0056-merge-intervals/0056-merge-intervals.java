class Solution {
	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
        //take the first interval
		int[] newInterval = intervals[0];
        //put into the list first
		result.add(newInterval);
		for (int[] interval : intervals) {
            //overlapping interval
			if (interval[0] <= newInterval[1]) 
                // not sure what kind of overlapping
                /*
                ------         ------------
                  -------  or      ---
                */
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
/*
1. HashMap record the restriction of this course <K,V> -> <prerequisite course, courses restrict by this course>
2. Restriction Array record the number of restriction of this course
3. Course Order
*/      
        if(numCourses == 0) return null;
        Map<Integer, List<Integer>> restrictionMap = new HashMap();
        int[] restrictNums = new int[numCourses];
        int[] order = new int[numCourses];
        int idx = 0;
        
        for(int i=0; i<prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            restrictionMap.putIfAbsent(pre, new ArrayList());
            restrictionMap.get(pre).add(course);
            restrictNums[course]++;
        }
        
        //use queue to check current taken class
        Queue<Integer> queue = new LinkedList();
        
        //add those courses that don't require prerequisites
        for(int i=0; i<numCourses; i++) {
            if(restrictNums[i] == 0) {
                order[idx++]=i;
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(restrictionMap.get(curr) != null) {
                for(int course: restrictionMap.get(curr)) {
                    if(--restrictNums[course] == 0) {
                        queue.offer(course);
                        order[idx++] = course;
                    }
                }
            }
            
        }
        return idx == numCourses ? order: new int[0];
    }
}
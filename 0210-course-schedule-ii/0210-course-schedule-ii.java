class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // the order to take course
        int[] order = new int[numCourses];
        int idx = 0;
        //checking restriction map
        //<key, value> -> <pre-course, list of courses> => by fulfilling pre-course, the list of courses can be taken
        Map<Integer, List<Integer>> map = new HashMap();
        
        if(numCourses == 0) return null;
        
        int[] indegree = new int[numCourses];
        //checking each course restriction, if yes ++ 1
        for(int i=0; i<prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            map.putIfAbsent(preCourse, new ArrayList());
            map.get(preCourse).add(course);
            indegree[course]++; // how many restriction this course have
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++) {
            //no restriction -> meaning can add course whenever 
            if(indegree[i] == 0) {
                queue.offer(i);
                order[idx++] = i;
            }
        }
        
        while(!queue.isEmpty()) {
            //already finished course -> check if other course can take because already taken this
            int prerequisite = queue.poll();
            if(map.get(prerequisite)!= null) {
                for(int course: map.get(prerequisite)) {
                    if(--indegree[course] == 0) {
                        queue.offer(course);
                        order[idx++] = course;
                    }
                }
            }
        }
        return idx == numCourses ? order: new int[0];
    }
}
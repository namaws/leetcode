class Solution {
    public int findMinArrowShots(int[][] points) {
        //find min arrows to burst balloons -> find overlap
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        
        int arrowPnt = points[0][1];
        int arrowCnt = 1;
        
        for(int i=1; i<points.length; i++) {
            //curr balloon start point is larger than arrowPoint
            //-> oo overlap need another arrow
            if(points[i][0] > arrowPnt) {
                arrowCnt++;
                arrowPnt = points[i][1];
            }
        }
        return arrowCnt;
    }
}
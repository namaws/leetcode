class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=1; i<triangle.size(); i++) {
            for(int j=0; j<=i; j++) {
                int smallestAbove = Integer.MAX_VALUE;

                //make sure it is not the first item in the row
                if(j>0)
                    smallestAbove = triangle.get(i-1).get(j-1);
                //make sure it is not the last item in the row
                if(j<i)
                    smallestAbove = Math.min(smallestAbove, triangle.get(i-1).get(j));

                triangle.get(i).set(j, smallestAbove+ triangle.get(i).get(j));
            }
        }
        return Collections.min(triangle.get(triangle.size()-1));
    }
}
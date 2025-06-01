class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=1; i<triangle.size(); i++) {
            for(int j=0; j<=i; j++) {
                int smallestAbove = Integer.MAX_VALUE;
                /**
                1. the first item will only go in the second if statement
                2. the item in the middle will go in both if statement
                3. the last item will go in the first statement
                 */
                if(j>0)
                    smallestAbove = triangle.get(i-1).get(j-1);
                
                if(j<i)
                    smallestAbove = Math.min(smallestAbove, triangle.get(i-1).get(j));

                triangle.get(i).set(j, smallestAbove+ triangle.get(i).get(j));
            }
        }
        return Collections.min(triangle.get(triangle.size()-1));
    }
}
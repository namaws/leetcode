class Solution {
    public int candy(int[] ratings) {
        //use another array to count
        int[] cntArr = new int[ratings.length];
        if(ratings.length == 1) return 1;
        Arrays.fill(cntArr,1);
        int cntTotal = 0;
        for(int i=1; i<ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                cntArr[i] = cntArr[i-1]+1;
            }
        }
        
        for(int i=ratings.length-1; i>=1; i--) {
            if(ratings[i-1]>ratings[i])
                cntArr[i-1] = Math.max(cntArr[i]+1, cntArr[i-1]);
        }
        
        for(int n: cntArr)
            cntTotal+=n;
        
        return cntTotal;
    }
}
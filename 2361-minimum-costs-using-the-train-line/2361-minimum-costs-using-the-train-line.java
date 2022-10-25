class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int len = regular.length;
        long[] dpRegular = new long[len+1];
        long[] dpExpress = new long[len+1];
        long[] result = new long[len];
        dpExpress[0] = expressCost;
        for(int i=0; i<len; i++) {
            dpRegular[i+1] = Math.min(dpRegular[i], dpExpress[i]) + regular[i];
            dpExpress[i+1] = Math.min(dpRegular[i]+expressCost, dpExpress[i]) + express[i];
            result[i] = Math.min(dpRegular[i+1], dpExpress[i+1]);
        }
        
        return result;
    }
}
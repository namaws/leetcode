class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for(int i=0; i<updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            
            result[start] += val;
            if((end+1)<length)
                result[end+1] -= val;
        }
        
        for(int i=1; i<length; i++) {
            result[i] += result[i-1];
        }
        return result;
    }
}
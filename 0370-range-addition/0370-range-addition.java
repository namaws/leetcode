class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        /*
        because it is a cumulative sums, we can actually do cumulative sum at the end
        we add the val onto the start index, and minus the val onto the index of end index + 1
        for example:
        [[1,3,2],[2,4,3],[0,2,-2]], length = 5
          0 1 2 3  4, 5
        [ 0,2,0,0,-2] -> 假設只有第一行，從頭開始加到尾 -> [0,2,2,2,0] 因為是累加，所以可以把query範圍都加好加滿，在query範圍外就要減掉
        [ 0,2,3,0,-2,-3]
        [-2,2,3,2,-2,-3] -> 若 end index + 1 over the range -> ignore it
        [-2,0,3,5,3]
        */
        int[] result = new int[length];
        for(int i=0; i<updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            
            result[start] += val;
            if(end < length-1) {
                result[end+1] -= val;
            }
        }
        
        for(int i=1; i<length; i++) {
            result[i] += result[i-1];
        }
        return result;
    }
}
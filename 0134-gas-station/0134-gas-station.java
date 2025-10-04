class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalDiff = 0, start = 0, currGas = 0;
        for(int i=0; i<gas.length; i++) {
            totalDiff += gas[i]-cost[i];
            currGas += gas[i]-cost[i];
            if(currGas < 0) {
                currGas = 0;
                start = i+1;
            }
        }
        return totalDiff >= 0? start: -1;
    }
}
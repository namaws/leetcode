class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int curr_gas = 0;
        int total_diff = 0; // diff between gas and cost
        
        for(int i=0; i<cost.length; i++) {
            total_diff += gas[i] - cost[i];
            curr_gas += gas[i] - cost[i];
            if(curr_gas < 0) {
                curr_gas = 0;
                start = i+1;
            } 
        }
        
        return total_diff >= 0 ? start:-1;
    }
}
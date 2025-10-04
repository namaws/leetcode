class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost):
            return -1
        total_diff, start = 0, 0

        for i in range(len(gas)):
            total_diff += gas[i]-cost[i]

            if total_diff < 0:
                total_diff = 0
                start = i+1
        return start
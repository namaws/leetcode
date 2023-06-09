class Solution {
    public int[] twoSum(int[] nums, int target) {
        //K,V -> nums[i] value, indices
        Map<Integer, Integer> map = new HashMap();
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++) {
            int remain = target-nums[i];
            if(map.containsKey(remain)) {
                res[0] = map.get(remain);
                res[1] = i;
                return res;
            }
            else 
                map.put(nums[i], i);
        }
        return null;
    }
}
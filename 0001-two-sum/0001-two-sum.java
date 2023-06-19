class Solution {
    public int[] twoSum(int[] nums, int target) {
        //<k,v> -> <nums value, index>
        Map<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++) {
            int remain = target - nums[i];
            if(map.containsKey(remain)) {
                result[0] = map.get(remain);
                result[1] = i;
            }
            else
                map.put(nums[i], i);
        }
        return result;
    }
}
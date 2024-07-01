class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //key, value -> value, indices
        Map<Integer, List<Integer>> map = new HashMap();
        
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList());
            else {
                List<Integer> list = map.get(nums[i]);
                for(int j=0; j<list.size(); j++) {
                    if(k >= Math.abs(i-list.get(j))) return true;
                }
              
            }
            map.get(nums[i]).add(i);  
        }
        return false;
    }
}
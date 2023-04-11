class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(nums, result, new ArrayList<Integer>());
        return result;
    }
    
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> curr) {
        if(curr.size()==nums.length) result.add(new ArrayList(curr));
        // start from 0, cuz we don't know the order
        for(int i=0; i<nums.length; i++) {
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            helper(nums, result, curr);
            curr.remove(curr.size()-1);
        }
    }
}
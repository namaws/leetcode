class Solution {
    private Set<List<Integer>> set = new HashSet();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, new ArrayList(), nums, set);
        List<List<Integer>> result = new ArrayList();
        for(List<Integer> list: set) {
            result.add(list);
        }
        return result;
    }

    private void backtrack(int index, List<Integer> curr, int[] nums, Set<List<Integer>> set) {
        if(!set.contains(curr)) {
            set.add(new ArrayList(curr));
        }
        for(int i=index; i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i+1, curr, nums, set);
            curr.remove(curr.size()-1);
        }

    }
}
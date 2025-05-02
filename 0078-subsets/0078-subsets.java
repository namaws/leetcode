class Solution {
    private List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, new ArrayList(), nums);
        /*
        List<List<Integer>> result = new ArrayList();
        for(List<Integer> list: set) {
            result.add(list);
        }
        */
        return result;
    }

    private void backtrack(int index, List<Integer> curr, int[] nums) {
        //if(!set.contains(curr)) {
            result.add(new ArrayList(curr));
        //}
        for(int i=index; i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i+1, curr, nums);
            curr.remove(curr.size()-1);
        }

    }
}
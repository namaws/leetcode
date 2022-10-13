class Solution {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> curr = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0);
        return result;
    }
    
    public void backtracking(int [] candidates, int remain, int startIdx) {
        if(remain == 0) {
            result.add(new ArrayList(curr));
            return;
        }
        if(remain < 0) {
            return;
        }
        
        for(int i=startIdx; i<candidates.length; i++) {
            curr.add(candidates[i]);
            backtracking(candidates, remain-candidates[i], i);
            curr.removeLast();
        }
    }
}
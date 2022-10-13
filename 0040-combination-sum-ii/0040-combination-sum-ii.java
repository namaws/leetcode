class Solution {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> curr = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }
    
    public void backtracking(int[] candidates, int remain, int startIdx) {
        if(remain == 0) {
            result.add(new ArrayList(curr));
            return;
        }
        
        for(int i=startIdx; i<candidates.length; i++) {
            if(i>startIdx && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(remain-candidates[i]<0) break;
            curr.add(candidates[i]);
            backtracking(candidates, remain-candidates[i], i+1);
            curr.removeLast();
        }
    }
}
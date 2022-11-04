class Solution {
    
    private int[] nums;
    private Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        for(int i=0; i<a.length; i++) {
            int idx = rand.nextInt(a.length);
            swap(a, i, idx);
        }
        return a;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
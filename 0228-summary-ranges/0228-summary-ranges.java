class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> list = new ArrayList();

        int left = 0, right = 0;
        for(int i=0; i<nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            while(i < nums.length-1 && nums[i]+1 == nums[i+1]) {
                i++;
                right++;
            }
            
            if(right == left) {
                list.add(String.valueOf(nums[left]));
            }
            else {
                sb.append(String.valueOf(nums[left]));
                sb.append("->");
                sb.append(String.valueOf(nums[right]));
                list.add(sb.toString());
            }
            right++;
            left = right;
        }
        
        return list;
    }
}
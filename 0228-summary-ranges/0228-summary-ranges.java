class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        List<String> list = new ArrayList();
        for(int i=0; i<nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            while(i<nums.length-1 && nums[i]+1 == nums[i+1]) {
                i++;
            }

            if(i == start)
                list.add(String.valueOf(nums[start]));
            else {
                sb.append(String.valueOf(nums[start]));
                sb.append("->");
                sb.append(String.valueOf(nums[i]));
                list.add(sb.toString());
            }
            start = i+1;
        }
        return list;
    }
}
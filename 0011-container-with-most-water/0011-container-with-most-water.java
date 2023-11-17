class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len-1;
        int maxContain = 0;
        while(left < right) {
            int curr = Math.min(height[left], height[right])*(right-left);
            maxContain = Math.max(maxContain, curr);
            if(height[left]<height[right])
                left++;
            else 
                right--;
        }
        return maxContain;
    }
}
class Solution {
    public int trap(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        
        while(left < right) {
            int currLeft = height[left];
            int currRight = height[right];
            if(height[left] < height[right]) {
                if(maxLeft <= height[left]) {
                    maxLeft = height[left];
                }
                else {
                    water += maxLeft - height[left];
                }
                left ++;
            }
            else {
                if(maxRight <= height[right]) {
                    maxRight = height[right];
                }
                else {
                    water += maxRight - height[right];
                }
                right--;
            }
        }
        return water;
    }
}


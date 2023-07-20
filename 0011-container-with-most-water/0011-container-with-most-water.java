class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int container = 0;
        while(left < right) {
            int currVol = Math.min(height[right], height[left])*(right-left);
            container = Math.max(container, currVol);
            //move the smaller value of pointer, as trying to find the max
            if(height[left]>=height[right]) right--;
            else left++;
        }
        return container;
    }
}
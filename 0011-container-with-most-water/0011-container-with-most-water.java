class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int container = 0;
        while(left <= right) {
            //current water container volumn
            int currVol = Math.min(height[left], height[right])*(right-left);
            container = Math.max(currVol, container);
            if(height[left] >= height[right]) right--;
            else left++;
        }
        return container;
    }
}
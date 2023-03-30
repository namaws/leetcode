class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int container = 0;
        while(left <= right) {
            int curr = Math.min(height[left], height[right])*(right-left);
            container = Math.max(curr, container);
            //can potential find bigger height if move right (since height[left] already bigger than height[right] at the current moment)
            if(height[left] >= height[right]) right--;
            else left++;
        }
        return container;
    }
}

/**
[1,8,6,2,5,4,8,3,7]
 ^               ^ (height.length-1)
              
*/

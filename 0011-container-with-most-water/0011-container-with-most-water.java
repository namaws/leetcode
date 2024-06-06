class Solution {
    public int maxArea(int[] height) {
        /*
        use two array to record maxLeft and maxRight at the moment? 
        */
        
        int left = 0, right = height.length-1;
        int capacity = 0;
        
        while(left < right) {
            capacity = Math.max(Math.min(height[left], height[right])* (right-left), capacity);
            if(height[left] <= height[right]) left++;
            else
                right--;
        }
        return capacity;
    }
}
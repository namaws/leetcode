class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0, ptr2 = numbers.length-1;
        int[] result = new int[2];
        while(ptr1 < ptr2) {
            int sum = numbers[ptr1]+numbers[ptr2];
            // cuz sorted, the only way to make sum smaller is to move ptr2 forward
            if(sum > target)
                ptr2--;
            else if(sum < target)
                ptr1++;
            else {
                result[0] = ptr1+1;
                result[1] = ptr2+1;
                break;
            }
        }
        return result;
    }
}
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [1]*len(nums)
        for i in range(1, len(nums), 1):
            prefix[i] = nums[i-1]*prefix[i-1]
        postfix = 1

        for i in range(len(nums)-2, -1, -1):
            prefix[i+1] *= postfix
            postfix *= nums[i+1]
        prefix[0] *= postfix
        return prefix
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def backtrack(start):
            if start == len(nums):
                res.append(nums.copy())
                return
            unique_set = set()

            for i in range(start, len(nums)):
                if nums[i] in unique_set:
                    continue
                unique_set.add(nums[i])
                nums[start], nums[i] = nums[i], nums[start]
                backtrack(start+1)
                nums[start], nums[i] = nums[i], nums[start]
        
        res = []
        backtrack(0)
        return res

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        used = [False] * len(nums)
        curr_permutation = []

        def backtrack():
            # Base case: if current permutation is complete
            if len(curr_permutation) == len(nums):
                res.append(curr_permutation[:])
                return

            # Try each number
            for i in range(len(nums)):
                if not used[i]:
                    curr_permutation.append(nums[i])
                    used[i] = True

                    backtrack()
                    # Unchoose (backtrack)
                    curr_permutation.pop()
                    used[i] = False

        backtrack()
        return res

class Solution(object):
    def combinationSum(self, candidates, target):
        
        res = []

        def backTrack(start, path, remaining):
            if remaining < 0:
                return
            if remaining == 0:
                res.append(path[:])
                return
            
            for i in range(start, len(candidates)):
                path.append(candidates[i])
                backTrack(i, path,remaining - candidates[i])
                path.pop()

        backTrack(0, [], target)
        return res

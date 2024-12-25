class Solution {
    public int minPatches(int[] nums, int n) {
        long currentSum = 1;
        int addedPatches = 0;
        int index = 0;

        while (currentSum <= n) {
            if (index < nums.length && nums[index] <= currentSum) {
                currentSum += nums[index];
                index++;
            } else {
                currentSum += currentSum;
                addedPatches++;
            }
        }
        return addedPatches;
    }
}

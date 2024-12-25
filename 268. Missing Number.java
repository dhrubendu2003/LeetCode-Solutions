class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int opSum = n*(n+1)/2;
        int orgSum = 0;

        for(int num : nums){
            orgSum += num;
        }
        return opSum - orgSum;
    }
}

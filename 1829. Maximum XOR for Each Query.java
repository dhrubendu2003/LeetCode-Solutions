class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] prefixXOR = new int[n];
        prefixXOR[0] = nums[0];
        
        for (int i = 1; i < n; ++i) {
            prefixXOR[i] = prefixXOR[i - 1] ^ nums[i];
        }
        
        int[] ans = new int[n];
        int mask = (1 << maximumBit) - 1;
        
        for (int i = n - 1; i >= 0; --i) {
            ans[n - 1 - i] = prefixXOR[i] ^ mask;
        }
        return ans;
    }
}

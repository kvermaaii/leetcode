class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        if(n == 1) return -1;
        long[] prefixSum = new long[n];
        long[] suffixProduct = new long[n];
        prefixSum[0] = nums[0];
        suffixProduct[n-1] = nums[n-1];
        // The maximum possible leftSum: The array can have at most 100,000 elements (10^5). The largest number inside the array is 1,000,000,000 (10^9). Therefore, the absolute highest that leftSum could ever possibly be is 100,000 * 1,000,000,000 = 100,000,000,000,000 (10^14).
        long MAX_LIMIT = 100_000L * 1_000_000_000L + 1;
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
            if(suffixProduct[n - i] > MAX_LIMIT / nums[n - 1 - i]) {
                suffixProduct[n - 1 - i] = MAX_LIMIT; 
            } else {
                suffixProduct[n - 1 - i] = suffixProduct[n - i]*nums[n - 1 - i];
            }
        } 
        //because rnums[i] starts from 1 product can never be zero hence index 0 can never be the answer
        //for index n-1 we can take product of left side as 1 and see if prefix sunm of n-2 is equal t0 1
        if(prefixSum[n-2] == 1) return n-1;
        for(int i = 0; i < n-2; i++){
            if(prefixSum[i] == suffixProduct[i+2]) return i+1;
        }
        return -1;
    }
}
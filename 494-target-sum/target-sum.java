class Solution {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += nums[i];
        }
        target = Math.abs(target);
        if((sum + target) % 2 != 0){
            return 0;
        }
        int x = (sum + target)/2;
        dp = new int[length+1][x+1];
        dp[0][0] = 1;
        for(int i = 1; i < length + 1; i++){
            for(int j = 0; j < x + 1; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j];
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[length][x];
        // return findTargetSum(nums, length, x);
    }
    public int findTargetSum(int[] nums, int n, int W){
        if (n == 0) return W == 0 ? 1 : 0;
        if(nums[n-1] <= W){
            return findTargetSum(nums, n-1, W - nums[n-1]) + findTargetSum(nums, n-1, W);
        } else{
            return findTargetSum(nums, n-1, W);
        }
    }
}
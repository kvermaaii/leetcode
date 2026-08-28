class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        Boolean[][] dp = new Boolean[n][sum];
        return rec(nums, 0, 0, sum, dp);
    }
    boolean rec(int[] nums, int i , int sum, int t, Boolean[][] dp){
        if(t - 2*sum == 0) return true;
        if(i >= nums.length) return false;
        if(dp[i][sum] != null) return dp[i][sum];
        boolean pick = rec(nums, i+1, sum + nums[i],t,dp);
        boolean pickNot = rec(nums, i+1, sum,t, dp);
        return dp[i][sum] = pick || pickNot;
    }
}